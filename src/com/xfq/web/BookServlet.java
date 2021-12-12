package com.xfq.web;

import com.xfq.pojo.Book;
import com.xfq.pojo.Page;
import com.xfq.service.BookService;
import com.xfq.service.impl.BookServiceImpl;
import com.xfq.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = WebUtils.parseInt(req.getParameter("pageNum"), 0);
        pageNum += 1;
        Book book = WebUtils.CopyParameterToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNum="+pageNum);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        bookService.deleteBookById(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNum="+req.getParameter("pageNum"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.CopyParameterToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNum="+req.getParameter("pageNum"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var book = bookService.queryBookById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book", book);

        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = WebUtils.parseInt(req.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.page_size);
        Page<Book> page = bookService.page(pageNum, pageSize);
        bookService.setUrl(page,"manager/bookServlet?action=page&pageNum=");
        req.setAttribute("page", page);
//      resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

}
