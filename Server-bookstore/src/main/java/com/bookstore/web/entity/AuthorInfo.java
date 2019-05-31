package com.bookstore.web.entity;

import com.bookstore.dbentity.Author;

import java.util.List;

public class AuthorInfo {
    private Author author;

    private List<FEBook> topSaleBooks;

    public AuthorInfo(Author author, List<FEBook> topSaleBooks) {
        this.author = author;
        this.topSaleBooks = topSaleBooks;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<FEBook> getTopSaleBooks() {
        return topSaleBooks;
    }

    public void setTopSaleBooks(List<FEBook> topSaleBooks) {
        this.topSaleBooks = topSaleBooks;
    }
}
