package com.weblibrary.dao.impl;

import com.weblibrary.daoport.TradeDAO;
import com.weblibrary.domain.Trade;

import java.util.List;
import java.util.Set;

public class TradeDAOImpl extends BaseDAO<Trade> implements TradeDAO {
    /**
     * 想数据表中插入Trade对象
     *
     * @param trade
     */
    @Override
    public void insert(Trade trade) {
        String sql = "insert into trade_table (tradeId,tradeTime,userId) values (?,?,?)";
         long i = insert(sql,trade.getTradeId(),trade.getTradeTime(),trade.getUserId());
        System.out.println(i);
    }

    /**
     * 根据userId获取和其相关的Trade的集合
     *
     * @param userId
     * @return
     */
    @Override
    public Set<Trade> getTradeWithUserId(Integer userId) {
        String sql ="select tradeId,tradeTime,userId from trade_table where userId = ?";
        List list = queryForList(sql,userId);
        System.out.println(list);
        return null;
    }
}
