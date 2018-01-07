package com.weblibrary.test;

import com.weblibrary.dao.impl.BookDAOImpl;

import com.weblibrary.domain.CriteriaBook;
import com.weblibrary.domain.Page;
import org.junit.Test;



public class BookDAOImplTest {
    BookDAOImpl bookDAO = new BookDAOImpl();
    @Test
    public void getBook() throws Exception {

        System.out.println( bookDAO.getBook(1));

    }

    @Test
    public void getPage() throws Exception {
        CriteriaBook cb = new CriteriaBook();
        cb.setPageNo(1);
        cb.setMinPrice(90);
        cb.setMaxPrice(400);
        Page page =  bookDAO.getPage(cb);
        System.out.println("pageNo = "+page.getPageNo());
        System.out.println("TotalItemNumber = "+page.getTotalItemNumber());
        System.out.println("list ="+page.getPageList());
        System.out.println("pageNext="+page.getPageNext());
        System.out.println("PagePrev="+page.getPagePrev());


        System.out.println(page);

    }

    @Test
    public void getToTalBookNumber() throws Exception {
        CriteriaBook cb = new CriteriaBook();
        cb.setPageNo(2);

        System.out.println(bookDAO.getToTalBookNumber(cb));
    }

    @Test
    public void getPageList() throws Exception {
        CriteriaBook cb = new CriteriaBook();
        cb.setPageNo(1);
        cb.setMaxPrice(400);
        System.out.println(bookDAO.getToTalBookNumber(cb));

    }

    @Test
    public void getStoreNumber() throws Exception {
        System.out.println(bookDAO.getStoreNumber(4));
    }



}
