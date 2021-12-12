package com.xfq.test;

import com.xfq.pojo.Cart;
import com.xfq.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    Cart cart=new Cart();
    @Test
    void addItem() {
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(300)));
        cart.addItem(new CartItem(1,"java入门",1,new BigDecimal(300)));
        cart.addItem(new CartItem(2,"C++",1,new BigDecimal(300)));
        cart.deleteItem(1);
        cart.updateCount(2,3);
        cart.addItem(new CartItem(3,"java入门2",1,new BigDecimal(300)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    void clear() {
    }

    @Test
    void deleteItem() {
    }

    @Test
    void updateCount() {
    }

    @Test
    void getItems() {
    }

    @Test
    void setItems() {
    }

    @Test
    void getTotalCount() {
    }

    @Test
    void getTotalPrice() {
    }
}