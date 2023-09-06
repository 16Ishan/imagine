package com.imagine.book.service.impl;

import com.imagine.book.model.entity.Book;
import com.imagine.book.services.BooksService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
class BookServiceImplTest
{
    @Autowired
    private BooksService booksService;

    @Test
    void testGetBookByIDHappyCase()
    {
        Book book = booksService.getBookByID(1);

        assertNotNull(book);
        assertNotNull(book.getBookId());
        assertEquals("Broken Glass",book.getTitle());
    }

    @Test
    void testGetBookByIDForInvalidID()
    {
        Book book = booksService.getBookByID(11);

        assertNull(book);
    }
}
