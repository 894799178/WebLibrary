package com.weblibrary.service;

import com.weblibrary.dao.impl.BookDAOImpl;
import com.weblibrary.daoport.BookDAO;
import com.weblibrary.domain.Book;
import com.weblibrary.domain.CriteriaBook;
import com.weblibrary.domain.Page;
import com.weblibrary.domain.ShoppingCart;

public class BookService {

    private BookDAO bookDAO = new BookDAOImpl();


    public Page<Book> getPage (CriteriaBook cb){
        return bookDAO.getPage(cb);
    }

    public Book getBook(Integer id){
        return bookDAO.getBook(id);
    }

    public boolean addToCart(int bookId, ShoppingCart sc) {
        Book book = bookDAO.getBook(bookId);

        if(book !=null){
            sc.addBook(book);
            return true;
        }
        return false;
    }

    public static void removeItenFromShoppingCart(ShoppingCart sc, int id) {
        sc.removeItem(id);
    }

    public static void clear(ShoppingCart sc) {
        sc.clear();
    }

    public static void updateItemQuantity(ShoppingCart sc, int id, int quantity) {
        sc.updateItemQuantity(id,quantity);
    }
}
