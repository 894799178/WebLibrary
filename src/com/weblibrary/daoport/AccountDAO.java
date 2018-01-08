package com.weblibrary.daoport;

import com.weblibrary.domain.Account;

public interface AccountDAO {
    /**
     * 根据account获取对应的 account 对象
     * @param accountId
     * @return
     */
    Account get(Integer accountId);

    /**
     * 设置对应account 中的 amount的数量
     * @param accountId
     * @param amount
     */
    void updateBalance(Integer accountId,float amount);
}
