package com.xfq.service.impl;

import com.xfq.dao.BookDao;
import com.xfq.dao.impl.BookDaoImpl;
import com.xfq.pojo.Book;
import com.xfq.pojo.Page;
import com.xfq.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNum, int pageSize) {
        var page=new Page<Book>();
        var pageTotalCount=bookDao.queryPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        page.setPageSize(pageSize);
        Integer pageTotal =pageTotalCount/pageSize+(pageTotalCount%pageSize>0?1:0);
        page.setPageTotal(pageTotal);
        page.setPageNum(pageNum);
        Integer begin = (page.getPageNum()-1)*pageSize;
        var items = bookDao.queryFormItems(begin, pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public void setUrl( Page page,String url) {
        page.setUrl(url);
    }

    @Override
    public Page<Book> pageByPrice(int pageNum, int pageSize, int min, int max) {
        var page=new Page<Book>();
        var pageTotalCount=bookDao.queryPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        page.setPageSize(pageSize);
        Integer pageTotal =pageTotalCount/pageSize+(pageTotalCount%pageSize>0?1:0);
        page.setPageTotal(pageTotal);
        page.setPageNum(pageNum);
        Integer begin = (page.getPageNum()-1)*pageSize;
        var items = bookDao.queryFormItemsByPrice(min,max,begin, pageSize);
        page.setItems(items);
        return page;
    }

}
