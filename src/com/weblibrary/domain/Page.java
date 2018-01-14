package com.weblibrary.domain;

import java.util.List;

/**
 * 该类封装了对于页面所需要显示的方法
 * 主要用于商品在页面上的显示
 * @param <T>
 */
public class Page <T> {
    //当前页数
    private int  pageNo;
    //配置当前页面显示的数据的最大个数
    private int pageSize = 3;

    //当前页面所要显示的元素;
    private List <T> pageList;

    //页面数据的总个数
    private long totalItemNumber;

    //通过构造器进行初始化设置当前页数.
    public Page(int pageNo) {
        this.pageNo = pageNo;
    }
    /**
     * 获取总页数...
     * @return
     */
    public int getTotalPageNumber(){
        int totalPageNumber =(int)(totalItemNumber / pageSize);
        if((totalItemNumber % pageSize) != 0){
            totalPageNumber++;
        }
        return totalPageNumber;
    }

    /**
     * 如果有下一页,那么获取下一页页数,否者返回当前页数
     * @return
     */
    public int getPageNext(){
        if(isHasNext()){
            return getPageNo() + 1;
        }
        return getPageNo();
    }

    /**
     * 如果有前一页,那么获取前一页,否者返回当前页面
     * @return
     */
    public int getPagePrev(){
        if(isHasPrev()){
            return getPageNo() -1;
        }
        return getPageNo();
    }

    /**
     * 判断是否有下一页.
     * @return
     */
    public boolean isHasNext(){
        if(getPageNo() < getTotalPageNumber()){
            return true;
        }
        return false;
    }

    /**
     * 判断是否有上一页
     * @return
     */
    public boolean isHasPrev(){
        if(getPageNo() >  1){
            return true;
        }
        return false;
    }

    /**
     * 获取当前页面的页数,做了容错处理,保证页数 始终 大于0 且 小于等于最大页数
     * @return
     */
    public int getPageNo() {
        if(pageNo <= 0){
            pageNo = 1;
        }
        if(pageNo > getTotalPageNumber()){
            pageNo=getTotalPageNumber();
        }
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List <T> pageList) {
        this.pageList = pageList;
    }

    public long getTotalItemNumber() {
        return totalItemNumber;
    }

    public void setTotalItemNumber(long totalItemNumber) {
        this.totalItemNumber = totalItemNumber;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageList=" + pageList +
                ", totalItemNumber=" + totalItemNumber +
                '}';
    }
}
