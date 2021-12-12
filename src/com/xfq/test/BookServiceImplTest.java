package com.xfq.test;

import com.xfq.pojo.Book;
import com.xfq.service.BookService;
import com.xfq.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
BookService bookService =new BookServiceImpl();
    @Test
    void addBook() {
        bookService.addBook(new Book(null,"小番茄的日常生活3","小番茄",new BigDecimal(200),"999999","10",null));
    }

    @Test
    void deleteBookById() {
        bookService.deleteBookById(21);

    }

    @Test
    void updateBook() {
        bookService.updateBook(new Book(23,"小番茄的日常生活","小番茄",new BigDecimal(200),"999999","10",null));

    }

    @Test
    void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    void queryBooks() {
        System.out.println(bookService.queryBooks());
    }

    @Test
    void page() {
        System.out.println(bookService.page(1,4));
    }
}