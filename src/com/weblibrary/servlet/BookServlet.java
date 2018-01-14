package com.weblibrary.servlet;


import com.sun.org.apache.xpath.internal.SourceTree;
import com.weblibrary.domain.Book;
import com.weblibrary.domain.CriteriaBook;
import com.weblibrary.domain.Page;
import com.weblibrary.domain.ShoppingCart;
import com.weblibrary.service.BookService;
import com.weblibrary.webutil.BookStoreWebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BookServlet extends HttpServlet {
    BookService bs = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodStr = req.getParameter("method");
        try {
            /* 通过反射去调用jsp传入的方法.*/
            Method method  =getClass().getDeclaredMethod(methodStr,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (Exception e) {

        }


    }
    protected void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String bookIdStr  = req.getParameter("bookId");
        int bookId = -1;
        boolean flag = false;
        try {
            bookId= Integer.parseInt(bookIdStr);
        }catch(Exception e){}
        if(bookId>0) {
            ShoppingCart sc = BookStoreWebUtil.getShoppingCart(req);
             flag=bs.addToCart(bookId, sc);
        }
        if(flag){
            getBooks(req,resp);
            return;
        }
        resp.sendRedirect("error.jsp");
    }

    /*
            通过反射调用该方法.获取对应的某本书的信息.
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIdStr = req.getParameter("bookId");
        Integer bookId = 0;
        try {
             bookId =Integer.parseInt(bookIdStr);
        }catch(Exception e){
            e.printStackTrace();
        }
        Book book = bs.getBook(bookId);
        req.setAttribute("book",book);
       req.getRequestDispatcher( "/book.jsp").forward(req,resp);
    }

    /*
          该方法通过反射调用,获取所需要的多本书籍信息.
     */
    protected void getBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNoStr = req.getParameter("pageNo");
        String maxPriceStr = req.getParameter("maxPrice");
        String minPriceStr = req.getParameter("minPrice");
        int pageNo = 1;
        int minPrice = 0;
        int maxPrice = Integer.MAX_VALUE;
        try {
            pageNo=  Integer.parseInt(pageNoStr);
        }catch (NumberFormatException e){}
        try {
            maxPrice=  Integer.parseInt(maxPriceStr);
        }catch (NumberFormatException e){}
        try {
            minPrice=  Integer.parseInt(minPriceStr);
        }catch (NumberFormatException e){}
        CriteriaBook cb = new CriteriaBook(minPrice,maxPrice,pageNo);
        Page<Book> page = bs.getPage(cb);
        req.setAttribute("bookPage",page);
        req.getRequestDispatcher("books.jsp").forward(req,resp);
    }


}
