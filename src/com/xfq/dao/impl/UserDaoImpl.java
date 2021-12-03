package com.xfq.dao.impl;

import com.xfq.dao.UserDao;
import com.xfq.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User QueryUserByUsername(String name) {
        String sql = "select `id`,`name`,`password`,`email` from t_user where name = ?";
        return Queryone(User.class, sql, name);
    }

    @Override
    public User QueryUserByUsernameAndPassword(String name, String password) {
        String sql = "select `id`,`name`,`password`,`email` from t_user where name=? and password=?;";
        return Queryone(User.class, sql, name, password);
    }

    @Override
    public boolean saveUser(User user) {
        String sql = "insert into t_user(`name`,`password`,`email`)values(?,?,?);";
        if (update(sql, user.getName(), user.getPassword(), user.getEmail()) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
