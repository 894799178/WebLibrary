package com.weblibrary.domain;

public class CriteriaBook {
    private int minPrice = 0;
    private int maxPrice = Integer.MAX_VALUE;
    private int pageNo;

    /**
     * 标准的书籍类, 用于条件查询.
     * 封装了  3个成员 最小价格 最大价格 书的id编号
     */
    public CriteriaBook() {
    }

    public CriteriaBook(int minPrice, int maxPrice, int pageNo) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.pageNo = pageNo;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }
    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
