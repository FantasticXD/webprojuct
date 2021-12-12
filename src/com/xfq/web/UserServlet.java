package com.xfq.web;

import com.google.gson.Gson;
import com.xfq.pojo.User;
import com.xfq.service.UserService;
import com.xfq.service.impl.UserServiceImpl;
import com.xfq.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    protected UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.CopyParameterToBean(req.getParameterMap(), new User());
        if (userService.login(user) == null) {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        User user = WebUtils.CopyParameterToBean(req.getParameterMap(), new User());
        if (token.equalsIgnoreCase(code)) {
                userService.registUser(user);
                req.getSession().setAttribute("user", user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("password", user.getPassword());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existUsername = userService.existUsername(username);
        Map<String,Object> stringObjectMap=new HashMap<>();
        stringObjectMap.put("existUsername",existUsername);
        Gson gson=new Gson();
        String toJson = gson.toJson(stringObjectMap);
        resp.getWriter().write(toJson);
    }
}
