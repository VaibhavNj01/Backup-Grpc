package com.reactive.reactivepostgresdemo.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table(name="books")
public class BookEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_sequence")
    @SequenceGenerator(name = "book_id_sequence", allocationSize = 1)
    @Column("book_id")
    private Long bookId;

    @Column("book_name")
    private String bookName;

    @Column("book_author")
    private String bookAuthor;
}
