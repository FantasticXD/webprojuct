package com.xfq.dao.impl;

import com.xfq.dao.BookDao;
import com.xfq.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into  t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`)VALUES(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from  t_book where id = ?";
        return update(sql, id);

    }

    @Override
    public int updateBook(Book book) {
        String sql = "update  t_book set `name`=? , `author`=? , `price`=? , `sales`=? , `stock`=? , `img_path`=? where id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImg_path(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select   `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from  t_book where id = ?";
        return Queryone(Book.class,sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select  `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from  t_book ";
        return QueryList(Book.class,sql);
    }

    @Override
    public int queryPageTotalCount() {
        String sql="select count(*) from t_book";
        var o =(Number)QuerySingal(sql);
        return o.intValue();
    }

    @Override
    public List<Book> queryFormItems(Integer begin, Integer pageSize) {
        String sql = "select  `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from  t_book limit ?,?";
        return QueryList(Book.class,sql,begin,pageSize);
    }

    @Override
    public int queryPageTotalCountByPrice(int min, int max) {
        String sql="select count(*) from t_book WHERE price between ? and ?";
        return ((Number) QuerySingal(sql,min,max)).intValue();
    }

    @Override
    public List<Book> queryFormItemsByPrice(int min, int max, Integer begin, int pageSize) {
        String sql = "select  `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from  t_book where price between ? and ? order by price limit ?,?";
        return QueryList(Book.class,sql,min,max,begin,pageSize);
    }


}
