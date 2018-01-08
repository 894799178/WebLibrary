package com.weblibrary.daoport;

import com.weblibrary.domain.TradeItem;

import java.util.Collection;
import java.util.Set;

public interface TradeItemDAO {
    /**
     * 批量保存TradeItem对象
     * @param item
     */
   void  batchSave(Collection<TradeItem> item);

    /**
     * 根据tradeId获取和其想关联的TradeItem的集合
     * @param tradeId
     * @return
     */
    Set<TradeItem> getTradeItemWithTradeId(Integer tradeId);

}
