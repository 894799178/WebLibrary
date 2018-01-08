package com.weblibrary.daoport;

import com.weblibrary.domain.Trade;

import java.util.Set;

public interface TradeDAO {
    /**
     * 想数据表中插入Trade对象
     * @param trade
     */
    void insert(Trade trade);

    /**
     * 根据userId获取和其相关的Trade的集合
     * @param userId
     * @return
     */
    Set<Trade> getTradeWithUserId(Integer userId);
}
