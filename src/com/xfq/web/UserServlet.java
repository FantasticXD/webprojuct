package com.xfq.web;

import com.xfq.pojo.User;
import com.xfq.service.UserService;
import com.xfq.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet{
    protected UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        if(userService.login(user)==null){
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
        else req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("6n6np".equalsIgnoreCase(code)) {
            if (userService.existUsername(username)) {
                req.setAttribute("msg","用户已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                User user = new User();
                user.setEmail(email);
                user.setName(username);
                user.setPassword(password);
                userService.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("email",email);

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }
}
