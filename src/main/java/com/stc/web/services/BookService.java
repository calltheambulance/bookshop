package com.stc.web.services;


import com.stc.web.dto.BookDto;
import com.stc.web.models.book.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    void addBook(BookDto bookDto);
    void deleteBook(Long id);
    void updateBook(BookDto bookDto);
    Optional<Book> getBook(Long id);
    Optional<Book> getByTitle(String title);
    List<Book> getAllBooks();
}
