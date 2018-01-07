package com.weblibrary.domain;

import java.sql.Date;

/*
 * book_id  int(11) auto_increment primary key,
	author varchar(255),
	title varchar(255) not null,
	price float,
	publishing_date date,
	sales_amount int(11),
	store_number int(11),
	remark varchar(255)
 */
public class Book {
    private int bookId;
    private String author;
    private String title;
    private  float price;
    private Date publicShingDate;
    private int salesAmount;
    private int storeNumber;
    private String remark;




    public Book() {
    }

    public Book(String author, String title, float price, Date publicShingDate, int salesAmount, int storeNumber, String remark) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.publicShingDate = publicShingDate;
        this.salesAmount = salesAmount;
        this.storeNumber = storeNumber;
        this.remark = remark;
    }

    public Book(int bookId, String author, String title, float price, Date publicShingDate, int salesAmount, int storeNumber, String remark) {
        this.bookId = bookId;
        this.author = author;
        this.title = title;
        this.price = price;
        this.publicShingDate = publicShingDate;
        this.salesAmount = salesAmount;
        this.storeNumber = storeNumber;
        this.remark = remark;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPublicShingDate() {
        return publicShingDate;
    }

    public void setPublicShingDate(Date publicShingDate) {
        this.publicShingDate = publicShingDate;
    }

    public int getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publicShingDate=" + publicShingDate +
                ", salesAmount=" + salesAmount +
                ", storeNumber=" + storeNumber +
                ", remark='" + remark + '\'' +
                '}';
    }
}
