package com.weblibrary.daoport;

import com.weblibrary.domain.User;

public interface UserDAO {
    /**
     * 根据名字获取用户的信息.
     * @return
     */
     User getUser(String userName);

}
