package com.weblibrary.test;

import com.weblibrary.dao.impl.TradeItemDAOImpl;
import com.weblibrary.domain.TradeItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TradeItemDAOImplTest {
   TradeItemDAOImpl tradeItemDAO = new TradeItemDAOImpl();
    @Test
    public void batchSave() throws Exception {
        Collection list = new ArrayList<TradeItem>();
        list.add(new TradeItem(0,10,1,1));
        list.add(new TradeItem(0,10,2,2));
        list.add(new TradeItem(0,10,2,2));
        tradeItemDAO.batchSave(list);
    }

    @Test
    public void getTradeItemWithTradeId() throws Exception {
        System.out.println(tradeItemDAO.getTradeItemWithTradeId(1));

    }


}
