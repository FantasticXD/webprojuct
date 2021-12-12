package com.xfq.service;


import com.xfq.pojo.Book;
import com.xfq.pojo.Page;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void  updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    Page<Book> page(int pageNum, int pageSize);
    public void setUrl(Page page, String url);
    Page<Book> pageByPrice(int pageNum, int pageSize, int min, int max);
}
