package com.stc.web.models.book;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_title")
    private String title;

    
    @Column(name = "book_publisher")
    private String publisher;

    @Column(name = "book_isbn")
    private String isbn;

    @Column(name = "book_author")
    private String author;


    @Column(name = "book_about")
    private String about;

    @Column(name = "book_price")
    private double price;
}
