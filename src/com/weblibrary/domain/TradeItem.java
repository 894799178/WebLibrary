package com.weblibrary.domain;

public class TradeItem {
    private int itemId;
    private int quantity;
    private int bookId;
    private int tradeId;

    public TradeItem() {
    }

    public TradeItem(int itemId, int quantity, int bookId, int tradeId) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.bookId = bookId;
        this.tradeId = tradeId;
    }

    @Override
    public String toString() {
        return "tradeItem{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", bookId=" + bookId +
                ", tradeId=" + tradeId +
                '}';
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }
}
