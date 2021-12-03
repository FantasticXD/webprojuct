package com.xfq.test;

import com.xfq.dao.UserDao;
import com.xfq.dao.impl.UserDaoImpl;
import com.xfq.pojo.User;
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
        UserDao userdao =new UserDaoImpl();
        //UserDaoImpl usert =new UserDaoImpl();
        System.out.printf(userdao.QueryUserByUsernameAndPassword("1971476216","123456").toString());
    }

    @Test
    void saveUser() {
        User xfq = new User(2, "xfqxfq", "159159", "xxd@xxd.com");
        UserDao userdao =new UserDaoImpl();
        //UserDaoImpl usert =new UserDaoImpl();
        Boolean b = userdao.saveUser(xfq);
        System.out.printf(b.toString());
    }
}