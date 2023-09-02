package com.imagine.book.controller;

import com.imagine.book.exceptions.AuthenticationFailedException;
import com.imagine.book.exceptions.BookNotFoundException;
import com.imagine.book.model.entity.Book;
import com.imagine.book.services.BooksService;
import com.imagine.book.services.OrdersService;
import com.imagine.book.services.impl.UsersServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController
{
    @Autowired
    private OrdersService ordersService;
    private static final String AUTH_MESSAGE = "Unauthorized User access. Please login.";

    @GetMapping(value = "/get-previous-orders")
    public ResponseEntity<Map<Integer, List<Book>>> getPreviousOrders()
    {
        try
        {
            if(StringUtils.isNotBlank(UsersServiceImpl.AUTH_TOKEN))
                return new ResponseEntity<>(ordersService.getPreviousOrders(), HttpStatus.OK);
            else
                throw new AuthenticationFailedException(AUTH_MESSAGE);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(new HashMap<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/place-order")
    public ResponseEntity<String> placeOrder()
    {
        try
        {
            if(StringUtils.isNotBlank(UsersServiceImpl.AUTH_TOKEN))
                return new ResponseEntity<>(ordersService.placeOrder(), HttpStatus.OK);
            else
                throw new AuthenticationFailedException(AUTH_MESSAGE);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
