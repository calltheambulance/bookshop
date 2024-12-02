package com.stc.web.controllers;

import com.stc.web.models.book.Book;
import com.stc.web.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookPageController {

    private final BookService bookService;

    @GetMapping("/{title}")
    public String book(@PathVariable String title, Model model) {
        Optional<Book> book = bookService.getByTitle(title);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        } else {
            return "redirect:/error";
        }
        return "book";
    }
}
