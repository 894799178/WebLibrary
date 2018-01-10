package com.weblibrary.test;

import com.weblibrary.dao.impl.UserDAOImpl;

import org.junit.Test;



public class UserDAOImplTest {
    UserDAOImpl u = new UserDAOImpl();
    @Test
    public void getUser() throws Exception {
        System.out.println(u.getUser("老王"));
    }


}
