package com.imagine.book.repositories;

import com.imagine.book.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer>
{
    @Query("from Book where title like '%:keyword%' or author like '%:keyword%' " +
            "or genre like '%:keyword%'")
    Optional<Book> searchBookByKeyword(String keyword);

    @Modifying
    @Transactional
    @Query("update Book b set b.quantity=:quantity where b.bookId=:bookId")
    void updateBookQuantity(Integer bookId, Integer quantity);
}
