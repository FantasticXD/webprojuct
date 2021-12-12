package com.xfq.dao;

import com.xfq.pojo.User;

public interface UserDao {
    /**
     *根据用户名查用户
     */
    public User QueryUserByUsername(String username);

    /**
     *根据用户名和密码查用户
     */
    public User QueryUserByUsernameAndPassword(String username,String password);

    /**
     *保存用户信息
     */
    public boolean saveUser(User user);
}
