package com.weblibrary.test;

import com.weblibrary.dao.impl.BaseDAO;
import com.weblibrary.dao.impl.BookDAOImpl;
import com.weblibrary.domain.Book;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.sql.Date;
import java.util.List;


public class BaseDAOTest {
    BaseDAO baseDAO = new BaseDAO();
    BookDAOImpl bookDAOImpl = new BookDAOImpl();
    @Test
    public void testInsert(){
        String sql = "insert into book_table (author,title,price,publicShingDate,salesAmount,storeNumber,remark) values (?,?,?,?,?,?,?)";
         long id =bookDAOImpl.insert(sql,"","算法4",390,new Date(new java.util.Date().getTime()),1,5,"emmmmm");
        System.out.println(id);
    }
    @Test
    public void testUpdate(){
        String sql = "update book_table set sales_amount = 2 where title = ?";
        bookDAOImpl.update(sql,"java编程思想");
    }
    @Test
    public void testQuery(){
        String sql = "select bookId,author,title,price,publicShingDate,salesAmount,storeNumber,remark from book_table where bookId = ?";
        Book book =null;
        book=  bookDAOImpl.query(sql,1);
        System.out.println(book);
    }
    @Test
    public void testQueryForList(){
        String sql = "select bookId,author,title,price,publicShingDate,salesAmount,storeNumber,remark from book_table";
        List list = null;
        list = bookDAOImpl.queryForList(sql);

        System.out.println(list);
    }

    @Test
    public void testGetSingleVal(){
        String sql = "select title from book_table where bookId=?";
        String s =  bookDAOImpl.getSingleVal(sql,1);
        System.out.println(s);
    }
    @Test
    public void testBatch(){
        String sql = "update book_table set title = ? where bookId = ?";
        bookDAOImpl.batch(sql, new Object[]{"javaWeb11",1},new Object[]{"javaWeb11",2});
    }

}
