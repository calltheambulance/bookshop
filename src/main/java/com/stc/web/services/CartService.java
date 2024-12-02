package com.stc.web.services;


import com.stc.web.models.Cart;
import com.stc.web.models.book.Book;
/*
**** Сервис корзины. Здесь объявлены функции подсчёта общей стоимости, удаления из корзины, добавления, очистки корзины и геттер для сущности корзины. ****
**** Методы реализованы в классе-имплементаторе ****
 */


public interface CartService {
    double getTotalPrice();
    void clearCart();
    Cart getCart();
    void addBook(Book book);
    void removeBook(long bookId);

}
