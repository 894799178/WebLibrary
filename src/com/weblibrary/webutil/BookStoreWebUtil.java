package com.weblibrary.webutil;

import com.weblibrary.domain.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BookStoreWebUtil {

    public static ShoppingCart getShoppingCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart)session.getAttribute("ShoppingCart");

        if(sc == null){
            sc =  new ShoppingCart();
            session.setAttribute("ShoppingCart",sc);
        }
        return sc;
    }

}
