package com.xfq.test;

import com.xfq.dao.BookDao;
import com.xfq.dao.impl.BookDaoImpl;
import com.xfq.pojo.Book;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoImplTest {
    BookDao bookDao=new BookDaoImpl();
    @Test
    void addBook() {
        System.out.println(bookDao.addBook(new Book(null,"小番茄的日常生活","小番茄",new BigDecimal(200),"999999","10",null)));
    }

    @Test
    void deleteBookById() {
        System.out.println(bookDao.deleteBookById(22));

    }

    @Test
    void updateBook() {
        System.out.println(bookDao.updateBook(new Book(21,"小番茄的日常生活2","小番茄",new BigDecimal(200),"999999","10",null)));

    }

    @Test
    void queryBookById() {
        System.out.println(bookDao.queryBookById(21));

    }

    @Test
    void queryBooks() {
        System.out.println(bookDao.queryBooks());
    }

    @Test
    void testAddBook() {
    }

    @Test
    void testDeleteBookById() {
    }

    @Test
    void testUpdateBook() {
    }

    @Test
    void testQueryBookById() {
    }

    @Test
    void testQueryBooks() {
    }

    @Test
    void queryPageTotalCount() {
        int i = bookDao.queryPageTotalCount();
        System.out.println(i);

    }

    @Test
    void queryFormItems() {
        System.out.println(bookDao.queryFormItems(0,4));
    }

    @Test
    void queryPageTotalCountByPrice() {
        System.out.println(bookDao.queryPageTotalCountByPrice(10,100));
    }

    @Test
    void queryFormItemsByPrice() {
        System.out.println(bookDao.queryFormItemsByPrice(10,100,0,4));
    }
}