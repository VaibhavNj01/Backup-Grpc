package com.reactive.reactivepostgresdemo.service;


import com.reactive.reactivepostgresdemo.BookRequest;
import com.reactive.reactivepostgresdemo.BookResponse;
import com.reactive.reactivepostgresdemo.ReactorBookServiceGrpc;
import com.reactive.reactivepostgresdemo.entity.BookEntity;
import com.reactive.reactivepostgresdemo.mapper.BookMapper;
import com.reactive.reactivepostgresdemo.repository.BookRepository;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@GrpcService
public class BookServiceImpl extends ReactorBookServiceGrpc.BookServiceImplBase {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Mono<BookResponse> createBook(Mono<BookRequest> request) {
        return request.flatMap(bookRequest -> {
            BookEntity bookEntity = new BookEntity();
            bookEntity.setBookName(bookRequest.getBookName());
            bookEntity.setBookAuthor(bookRequest.getBookAuthor());
            return bookRepository.save(bookEntity)
                    .map(savedBookEntity -> {
                        BookResponse bookResponse = BookResponse.newBuilder()
                                .setBookId(savedBookEntity.getBookId())
                                .build();
                        return bookResponse;
                    });
        });
    }

    @Override
    public Mono<BookRequest> getBookInfo(Mono<BookResponse> request) {
        return request.flatMap(bookResponse -> {
            Long bookId = bookResponse.getBookId();

            // Use the bookId to retrieve the corresponding BookEntity from the database
            return bookRepository.findById(Math.toIntExact(bookId))
                    .map(foundBookEntity -> {
                        BookRequest bookRequest = BookRequest.newBuilder()
                                .setBookId(foundBookEntity.getBookId())
                                .setBookName(foundBookEntity.getBookName())
                                .setBookAuthor(foundBookEntity.getBookAuthor())
                                .build();
                        return bookRequest;
                    });
        });
    }
}

