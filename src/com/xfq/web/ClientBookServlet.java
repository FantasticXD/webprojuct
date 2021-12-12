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

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = WebUtils.parseInt(req.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.page_size);
        Page<Book> page = bookService.page(pageNum, pageSize);
        bookService.setUrl(page,"client/bookServlet?action=page&pageNum=");
        req.setAttribute("page", page);
//      resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = WebUtils.parseInt(req.getParameter("pageNum"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.page_size);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNum, pageSize,min,max);
        var sb =new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min")!=null){
            sb.append("&min=").append(req.getParameter("min"));
        }
       if (req.getParameter("max")!=null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        sb.append("&pageNum=");
        bookService.setUrl(page,sb.toString());
        req.setAttribute("page", page);
//        req.setAttribute("min",min);
//        req.setAttribute("max",max);
//      resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
