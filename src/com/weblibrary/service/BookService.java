package com.weblibrary.service;

import com.weblibrary.dao.impl.BookDAOImpl;
import com.weblibrary.daoport.BookDAO;
import com.weblibrary.domain.Book;
import com.weblibrary.domain.CriteriaBook;
import com.weblibrary.domain.Page;

public class BookService {

    private BookDAO bookDAO = new BookDAOImpl();


    public Page<Book> getPage (CriteriaBook cb){
        return bookDAO.getPage(cb);
    }

    public Book getBook(Integer id){
        return bookDAO.getBook(id);
    }
}
