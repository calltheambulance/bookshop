package com.stc.web.services;

import com.stc.web.models.Cart;
import com.stc.web.models.CartItem;
import com.stc.web.models.book.Book;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartServiceImpl implements CartService {


    private Cart cart;

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void addBook(Book book) {
        if (cart == null) {
            cart = new Cart();
        }
        cart.addItem(book);
    }

    @Override
    public void removeBook(long bookId) {
        cart.removeItem(bookId);
    }


    @Override
    public double getTotalPrice() {
        return cart.getTotalPrice();
    }




    @Override
    public void clearCart() {
        cart.clearCart();
    }


}
