package com.stc.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {

    private String title;

    private String publisher;

    private String isbn;

    private String author;

    private String about;

    private double price;
}
