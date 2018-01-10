package com.weblibrary.dao.impl;

import com.weblibrary.daoport.UserDAO;
import com.weblibrary.domain.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO{
    /**
     * 根据名字获取用户的信息.
     *
     * @param userName
     * @return
     */
    @Override
    public User getUser(String userName) {
        String sql = "select * from user_table where userName = ?";
        return query(sql,userName);
    }
}
