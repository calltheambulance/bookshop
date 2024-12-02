package com.stc.web.models;

import com.stc.web.models.book.Book;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;


@Getter
@Component
@SessionScope
public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Book book) {
        for (CartItem item : items) {
            if (item.getBook().getId().equals(book.getId())) {
                item.incrementQuantity();
                return;
            }
        }
        items.add(new CartItem(book));
    }

    public void removeItem(Long bookId) {
        items.removeIf(item -> item.getBook().getId().equals(bookId));
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(item -> item.getBook().getPrice() * item.getQuantity()).sum();
    }

    public void clearCart() {
        items.clear();
    }


}
