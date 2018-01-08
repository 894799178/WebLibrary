package com.weblibrary.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Trade {
    private int tradeId;
    private Timestamp tradeTime;
    private int userId;

    public Trade() {
    }

    public Trade(int tradeId, Timestamp tradeTime, int userId) {
        this.tradeId = tradeId;
        this.tradeTime = tradeTime;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", tradeTime=" + tradeTime +
                ", userId=" + userId +
                '}';
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public Timestamp getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Timestamp tradeTime) {
        this.tradeTime = tradeTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
