package com.xfq.web;

import com.xfq.pojo.User;
import com.xfq.service.UserService;
import com.xfq.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        if(userService.login(user)==null){
            req.getRequestDispatcher("/pages/user/login.html").forward(req,resp);
        }
        else req.getRequestDispatcher("/pages/user/login_success.html").forward(req,resp);
    }
}
