package com.weblibrary.dao.impl;

import com.weblibrary.daoport.AccountDAO;
import com.weblibrary.domain.Account;

public class AccountDAOImpl  extends BaseDAO<Account> implements AccountDAO {


    /**
     * 根据account获取对应的 account 对象
     *
     * @param accountId
     * @return
     */
    @Override
    public Account get(Integer accountId) {
        String sql = "select accountId,balance from account_table where accountId = ? ";
        return query(sql,accountId);
    }

    /**
     * 设置对应account 中的 amount的数量
     * @param accountId
     * @param amount
     */
    @Override
    public void updateBalance(Integer accountId, float amount) {
        String sql = "update  account_table set balance = ?  where accountId = ? ";
        update(sql,amount,accountId);
    }
}
