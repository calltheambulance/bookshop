package com.stc.web.controllers;
/*
**** Контроллер главной страницы: ****
**** Здесь будет выдаваться каталог продуктов. ****
**** При нажатии на продукт. пользователя перенаправит на страницу продукта ****
 */

import com.stc.web.models.book.Book;
import com.stc.web.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainPageController {


    private final BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

}
