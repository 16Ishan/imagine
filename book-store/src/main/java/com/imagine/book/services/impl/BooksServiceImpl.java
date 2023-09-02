package com.imagine.book.services.impl;

import com.imagine.book.exceptions.BookNotFoundException;
import com.imagine.book.model.entity.Book;
import com.imagine.book.repositories.BookRepository;
import com.imagine.book.services.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BooksServiceImpl implements BooksService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks()
    {
        List<Book> bookList = new ArrayList<>();
        try
        {
            bookList = bookRepository.findAll();
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Book getBookByID(Integer id)
    {
        try
        {
            Optional<Book> bookOptional = bookRepository.findById(id);
            if(bookOptional.isPresent())
            {
                return bookOptional.get();
            }
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book searchBook(String keyword)
    {
        try
        {
            Optional<Book> bookOptional = bookRepository.searchBookByKeyword(keyword);
            if(bookOptional.isPresent())
            {
                return bookOptional.get();
            }
            else
                throw new BookNotFoundException("No books found with the given keyword.");
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
