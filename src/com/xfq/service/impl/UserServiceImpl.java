package com.xfq.service.impl;

import com.xfq.dao.UserDao;
import com.xfq.dao.impl.UserDaoImpl;
import com.xfq.pojo.Page;
import com.xfq.pojo.User;
import com.xfq.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userdao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userdao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userdao.QueryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userdao.QueryUserByUsername(username) == null) {
            return false;
        }

        return true;
    }

    @Override
    public void setUrl(Page page, String url) {
        page.setUrl(url);
    }
}
