package com.xfq.test;

import com.xfq.dao.UserDao;
import com.xfq.dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {

    @Test
    void queryUserByUsername() {
        UserDao userdao =new UserDaoImpl();
        //UserDaoImpl usert =new UserDaoImpl();
        System.out.printf(userdao.QueryUserByUsername("1971476216").toString());
    }

    @Test
    void queryUserByUsernameAndPassword() {
    }

    @Test
    void saveUser() {
    }
}