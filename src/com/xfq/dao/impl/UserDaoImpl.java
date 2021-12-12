package com.xfq.dao.impl;

import com.xfq.dao.UserDao;
import com.xfq.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User QueryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username   = ?";
        return Queryone(User.class, sql, username);
    }

    @Override
    public User QueryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return Queryone(User.class, sql, username, password);
    }


    @Override
    public boolean saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`)values(?,?,?);";
        if (update(sql, user.getUsername(), user.getPassword(), user.getEmail()) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
