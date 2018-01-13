package com.weblibrary.servlet;


import com.weblibrary.domain.Book;
import com.weblibrary.domain.CriteriaBook;
import com.weblibrary.domain.Page;
import com.weblibrary.service.BookService;

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
