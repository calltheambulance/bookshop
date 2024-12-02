package com.stc.web.controllers;

import com.stc.web.dto.BookDto;
/*
TODO: сделать функцию апдейта книги и удаления
 */

import com.stc.web.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminPageController {

    private final BookService bookService;

    @GetMapping("/admin")
    public String adminPage() {
        return "/adminpage";
    }



    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("bookDto", new BookDto());
        return "/addBook";
    }

    @PostMapping("/addBook")
    public String addBook(BookDto bookDto) {
        bookService.addBook(bookDto);
        return "redirect:/admin";

    }



}
