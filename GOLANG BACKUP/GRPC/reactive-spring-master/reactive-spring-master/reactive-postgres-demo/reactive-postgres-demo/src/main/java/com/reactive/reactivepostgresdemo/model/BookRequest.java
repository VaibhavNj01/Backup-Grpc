package com.reactive.reactivepostgresdemo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest  {
    private String bookName;
    private String bookAuthor;

}
