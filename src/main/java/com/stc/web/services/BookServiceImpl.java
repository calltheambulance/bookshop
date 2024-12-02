package com.stc.web.services;

import com.stc.web.dto.BookDto;
import com.stc.web.models.book.Book;
import com.stc.web.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void addBook(BookDto bookDto) {
        Book book = Book
                .builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .isbn(bookDto.getIsbn())
                .publisher(bookDto.getPublisher())
                .author(bookDto.getAuthor())
                .about(bookDto.getAbout())
                .price(bookDto.getPrice())
                .build();
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateBook(BookDto bookDto) {

    }

    @Override
    public Optional<Book> getBook(Long id) {
       return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> getByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
