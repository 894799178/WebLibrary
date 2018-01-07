package com.weblibrary.daoport;

import java.util.List;

public interface DAO<T> {
     /**
      * 执行 insert操作,完成后返回插入的id.
      * @param sql
      * @param args
      * @return
      */
     long insert(String sql,Object ... args);

     /**
      * 执行update操作.包括insert,update,delete (但是无返回值)
      * @param sql
      * @param args
      */
     void update(String sql,Object ... args);

     /**
      * 执行单条查询操作,返回与纪录对应的类的一个对象
      * @param sql
      * @param args
      * @return
      */
     T query(String sql, Object ...args);

     /**
      * 执行查询,返回多个对象,对象使用list存储.
      * @param sql
      * @param args
      * @return
      */
     List <T> queryForList(String sql,Object ... args);

     /**
      * 获取某个单一数据,比如 最大值,查询的数据的数量....
      * @param sql
      * @param args
      * @param <V>
      * @return
      */
     <V> V getSingleVal(String sql,Object ...args);

     /**
      * 批量处理sql
      * @param sql
      * @param params
      */
     void batch(String sql,Object[] ... params);


}
