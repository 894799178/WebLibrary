package com.weblibrary.dao.impl;

import com.weblibrary.daoport.TradeItemDAO;
import com.weblibrary.domain.TradeItem;

import java.util.Collection;
import java.util.Set;

public class TradeItemDAOImpl extends BaseDAO<TradeItem> implements TradeItemDAO {
    /**
     * 批量保存TradeItem对象
     * @param item
     */
    @Override
    public void batchSave(Collection<TradeItem> item) {
        String sql = "insert into trade_item (itemId,quantity,bookId,tradeId) values(?,?,?,?) ";
        int [][] temp= new int [item.size()][4];
        int i =0;
        for (TradeItem ti: item) {
            temp[i][0] =ti.getItemId();
            temp[i][1] =ti.getQuantity();
            temp[i][2] =ti.getBookId();
            temp[i++][3] =ti.getTradeId();
        }

        Object [] tradeItems= item.toArray();
        batch(sql,temp);
    }

    /**
     * 根据tradeId获取和其想关联的TradeItem的集合
     * @param tradeId
     * @return
     */
    @Override
    public Set<TradeItem> getTradeItemWithTradeId(Integer tradeId) {
        return null;
    }
}
