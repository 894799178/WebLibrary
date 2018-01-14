package com.weblibrary.domain;

/**
 * 该类是用于购物车中的物品.封装了book对象和 book对象的数量,以及一些方法
 */
public class ShoppingCartItem {
    private  Book book;
    private int quantity; //书的数量
    public ShoppingCartItem() {
    }
    public ShoppingCartItem(Book book) {
        this.book = book;
        this.quantity = 1;
    }
    public void increment(){
        quantity++;
    }

    public float getMoney(){
        return book.getPrice()* quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
