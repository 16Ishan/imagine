package com.imagine.book.service.impl;

import com.imagine.book.model.entity.Book;
import com.imagine.book.repositories.BookRepository;
import com.imagine.book.services.impl.BooksServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(MockitoJUnitRunner.class)
class BookServiceImplMockitoTest
{
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BooksServiceImpl booksServiceImpl;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookByIDHappyCase()
    {
        Book book = Book.builder()
                .bookId(1)
                .title("Broken Glass")
                .author("Helen Stevenson")
                .genre("mystery")
                .price(100.0)
                .quantity(10)
                .build();

        Optional<Book> bookOptional = Optional.of(book);
        when(bookRepository.findById(any(Integer.class))).thenReturn(bookOptional);

        Book bookMock = booksServiceImpl.getBookByID(0);

        assertNotNull(bookMock);
        assertNotNull(bookMock.getBookId());
        assertEquals("Broken Glass",bookMock.getTitle());
    }
}
