package com.xfq.web;

import com.google.gson.Gson;
import com.xfq.pojo.Book;
import com.xfq.pojo.Cart;
import com.xfq.pojo.CartItem;
import com.xfq.service.BookService;
import com.xfq.service.impl.BookServiceImpl;
import com.xfq.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = WebUtils.parseInt(req.getParameter("bookId"), 0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        var cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        cart.addItem(cartItem);
        Map<String,Object> resultMap=new HashMap<String,Object>();
        req.getSession().setAttribute("cart", cart);
        req.getSession().setAttribute("lastName", book.getName());
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",book.getName());
        Gson gson=new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);


//        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = WebUtils.parseInt(req.getParameter("bookId"), 0);
        var cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);
        } else {
            cart.deleteItem(id);
            req.getSession().setAttribute("cart", cart);
            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);
        }
    }

    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var id = WebUtils.parseInt(req.getParameter("itemId"), 0);
        var count = WebUtils.parseInt(req.getParameter("count"), 1);
        var cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);
        } else {
            cart.updateCount(id,count);
            req.getSession().setAttribute("cart", cart);
            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);
        } else {
            cart.clear();
            req.getSession().setAttribute("cart", cart);
            req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req, resp);
        }
    }

}
