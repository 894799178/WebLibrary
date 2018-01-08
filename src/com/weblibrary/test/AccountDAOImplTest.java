package com.weblibrary.test;

import com.weblibrary.dao.impl.AccountDAOImpl;
import com.weblibrary.domain.Account;
import org.junit.Test;



public class AccountDAOImplTest {
    AccountDAOImpl adao = new AccountDAOImpl();
    @Test
    public void get() throws Exception {
      Account account   = adao.get(1);
        System.out.println(account);
    }

    @Test
    public void updateBalance() throws Exception {
           adao.updateBalance(1,50);
    }


}
