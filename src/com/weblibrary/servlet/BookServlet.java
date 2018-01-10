package com.weblibrary.servlet;


import com.weblibrary.domain.CriteriaBook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            minPrice=  Integer.parseInt(maxPriceStr);
        }catch (NumberFormatException e){}
        try {
            maxPrice=  Integer.parseInt(minPriceStr);
        }catch (NumberFormatException e){}
        CriteriaBook cb = new CriteriaBook(maxPrice,minPrice,pageNo);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


}
