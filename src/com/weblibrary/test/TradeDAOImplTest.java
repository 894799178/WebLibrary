package com.weblibrary.test;


import com.weblibrary.dao.impl.TradeDAOImpl;
import com.weblibrary.domain.Trade;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;


public class TradeDAOImplTest {
    TradeDAOImpl t = new TradeDAOImpl();
    @Test
    public void insert() throws Exception {
        Trade trade = new Trade(0,new Timestamp( new Date().getTime()),1);
        t.insert(trade);
    }

    @Test
    public void getTradeWithUserId() throws Exception {
        t.getTradeWithUserId(1);
    }



}
