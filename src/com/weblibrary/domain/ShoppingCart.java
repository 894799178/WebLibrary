package com.weblibrary.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Integer,ShoppingCartItem> books =  new HashMap<>();

    /**
     * 向购物车中添加书籍
     * @param book
     */
    public void addBook(Book book){
        ShoppingCartItem sci = null;
        int bookId = book.getBookId();
        if (hasBook(bookId)){
            sci =  books.get(bookId);
            sci.increment();
            return;
        }
        sci =  new ShoppingCartItem(book);
        books.put(bookId,sci);
    }

    /**
     * 根据该id 校验该商品是否存在
     * @param bookId
     * @return
     */
    public boolean hasBook(Integer bookId){
        if (books.get(bookId)!= null){
            return true;
        }
        return false;
    }

    /**
     * 返回一个map类型的 books键值对
     * @return map
     */
    public Map<Integer, ShoppingCartItem> getBooks() {
        return books;
    }

    /**
     * 获得map中所有的ShoppingCartItem组成的集合
     * @return
     */
    public Collection<ShoppingCartItem> getItems(){
        return books.values();
    }

    /**
     * 获取所有商品(书籍)的数量
     * @return
     */
    public int getBookNumber(){
        int total = 0;
        for (ShoppingCartItem sci : getItems()){
            total+= sci.getQuantity();
        }

        return total;
    }

    /**
     * 获取所有商品(书籍)的价值
     * @return
     */
    public float getTotalMoney(){
        Collection <ShoppingCartItem> collection= getItems();
        float totalMoney = 0;
        for (ShoppingCartItem sci: collection) {
            totalMoney+=sci.getMoney();
        }
        return totalMoney;
    }

    /**
     * 该map对象是否为空
     * @return
     */
    public boolean isEmpty(){
        return books.isEmpty();
    }

    /**
     * 清空该map对象中的数据
     */
    public void clear(){
        books.clear();
    }

    /**
     * 按照给定的bookId 清除map中对应的数据
     * @param bookId
     */
    public void removeItem(int bookId){
        books.remove(bookId);
    }

    /**
     * 根据bookId 更新对应商品的价数量
     * @param bookId
     * @param number
     */
    public void updateItemQuantity(int bookId,int number){
         if(hasBook(bookId)){
             ShoppingCartItem sci = books.get(bookId);
             sci.setQuantity(number);
         }
    }
}
