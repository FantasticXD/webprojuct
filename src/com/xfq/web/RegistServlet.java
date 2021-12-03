package com.xfq.web;

import com.xfq.dao.impl.UserDaoImpl;
import com.xfq.pojo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegistServlet extends HttpServlet {
    private UserDaoImpl usercontron=new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("username");
        if(usercontron.QueryUserByUsername(username) == null){
            User user = new User();
            user.setEmail(email);
            user.setName(username);
            user.setPassword(password);
            usercontron.saveUser(user);
            resp.sendRedirect("");
        }


    }
}
