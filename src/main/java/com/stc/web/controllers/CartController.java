package com.stc.web.controllers;


import com.stc.web.models.book.Book;
import com.stc.web.services.BookService;
import com.stc.web.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//TODO: Корзина при отсутствии элементов нулловая. удаление элементов из корзины не работает


import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    private final BookService bookService;

    @Autowired
    public CartController(CartService cartService, BookService bookService) {
        this.cartService = cartService;
        this.bookService = bookService;
    }

    @PostMapping("/add/{bookId}")
    public String addBookToCart(Model model, @PathVariable Long bookId) {
        Optional<Book> bookOptional = bookService.getBook(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            cartService.addBook(book);
            model.addAttribute("message", "Книга добавлена в корзину");
            return "redirect:/cart";
        } else {
            model.addAttribute("error", "Книга не найдена");
            return "redirect:/";
        }
    }

    @PostMapping("/remove")
    public String removeBookFromCart(Long bookId) {
        cartService.removeBook(bookId);
        return "redirect:/cart";
    }

    @GetMapping
    public String viewCart(Model model) {
        model.addAttribute("items", cartService.getCart().getItems());
        model.addAttribute("total", cartService.getTotalPrice());
        return "cart";
    }


}
