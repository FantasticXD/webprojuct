package com.xfq.service;

import com.xfq.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * */
    public  void  registUser(User user);
    /**
     * 登陆
     * */
    public  User login(User user);
    /**
     * 检查用户名是否可用
     * 返回true表示用户名存在
     * */
    public boolean existUsername(String username);
}
