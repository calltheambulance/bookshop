package com.stc.web.repository;

import com.stc.web.models.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ShopRepository extends JpaRepository<Book, Long> {

}
