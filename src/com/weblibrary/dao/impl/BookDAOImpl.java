package com.weblibrary.dao.impl;

import com.weblibrary.daoport.BookDAO;
import com.weblibrary.domain.Book;
import com.weblibrary.domain.CriteriaBook;
import com.weblibrary.domain.Page;

import java.util.Collection;
import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    /**
     * 根据id 获取指定book 对象
     *
     * @param id
     * @return
     */
    @Override
    public Book getBook(int id) {
        String sql = "select bookId,author,title,price,publicShingDate,salesAmount,storeNumber,remark from book_table where bookId = ?";
        return query(sql,id);
    }

    /**
     * 根据传入的CriteriaBook对象返回对应的Page对象
     *
     * @param cb
     * @return
     */
    @Override
    public Page<Book> getPage(CriteriaBook cb) {
        Page page =  new Page<Book>(cb.getPageNo());
        page.setTotalItemNumber(getToTalBookNumber(cb));
        page.setPageList(getPageList(cb,3));
        return page;
    }

    /**
     * 根据传入的CriteiaBook 对象返回其对应的数值
     * @param cb
     * @return
     */
    @Override
    public long getToTalBookNumber(CriteriaBook cb) {
        String sql = "select count(*) from book_table where price >= ? and price <= ?";

        return  getSingleVal(sql,cb.getMinPrice(),cb.getMaxPrice());
    }

    /**
     * 根据传入的CriteriaBook和pageSize返回当前页对应的List
     *
     * @param cb
     * @param pageSize
     * @return
     */
    @Override
    public List<Book> getPageList(CriteriaBook cb, int pageSize) {
        String sql = "select bookId,author,title,price,publicShingDate,salesAmount,storeNumber,remark from book_table where price >= ? and price <= ? limit ?,?";

        return queryForList(sql,cb.getMinPrice(),cb.getMaxPrice(), pageSize*(cb.getPageNo()-1),pageSize);
    }

    /**
     * 返回制定id的book的storeNumber字段的值
     *
     * @param id
     * @return
     */
    @Override
    public int getStoreNumber(Integer id) {
        String sql = "select storeNumber from book_table where bookId=?";
        return  getSingleVal(sql,id);
    }

    /**
     * 根据传入的shoppingCartItem 的集合,
     * 批量更新books数据表的StoreNumber和 SalesAmount 字段的值
     * !!!!! 参数值的 ShoppingCartItem未实现.
     *
     * @param item
     */
    @Override
    public void batchUpdateStoreNumberAndSalesAmount(Collection<Object> item) {

    }
}
