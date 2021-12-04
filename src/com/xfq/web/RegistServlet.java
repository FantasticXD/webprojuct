package com.xfq.web;

import com.xfq.dao.impl.UserDaoImpl;
import com.xfq.pojo.User;
import com.xfq.service.UserService;
import com.xfq.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("username");
        String code = req.getParameter("code");
        if ("6n6np".equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                User user = new User();
                user.setEmail(email);
                user.setName(username);
                user.setPassword(password);
                userService.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }

    }
}
