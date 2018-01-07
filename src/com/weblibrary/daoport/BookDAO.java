package com.weblibrary.daoport;

import com.weblibrary.domain.Book;
import com.weblibrary.domain.CriteriaBook;
import com.weblibrary.domain.Page;

import java.util.Collection;
import java.util.List;

public interface BookDAO {
    /**
     * 根据id 获取指定book 对象
     * @param id
     * @return
     */
     Book getBook(int id);

    /**
     * 根据传入的CriteriaBook对象返回对应的Page对象
     * @param cb
     * @return
     */
     Page<Book> getPage(CriteriaBook cb);

    /**
     * 根据传入的CriteiaBook 对象返回其对应的记录数
     * @param cb
     * @return
     */
     long getToTalBookNumber(CriteriaBook cb);

    /**
     * 根据传入的CriteriaBook和pageSize返回当前页对应的List
     * @param cb
     * @param pageSize
     * @return
     */
      List<Book> getPageList(CriteriaBook cb,int pageSize);

    /**
     * 返回制定id的book的storNumber字段的值
     * @param id
     * @return
     */
     int getStoreNumber(Integer id);

    /**
     * 根据传入的shoppingCartItem 的集合,
     * 批量更新books数据表的StoreNumber和 SalesAmount 字段的值
     * !!!!! 参数值的 ShoppingCartItem未实现.
     * @param item
     */
     void batchUpdateStoreNumberAndSalesAmount(Collection<Object> item);

}
