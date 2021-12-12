package com.xfq.dao;

import com.xfq.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deleteBookById(Integer id);
    public  int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public int queryPageTotalCount();
    public List<Book> queryFormItems(Integer begin ,Integer pageSize);

    int queryPageTotalCountByPrice(int min, int max);

    List<Book> queryFormItemsByPrice(int min, int max, Integer begin, int pageSize);
}
