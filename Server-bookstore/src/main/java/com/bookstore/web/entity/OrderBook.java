package com.bookstore.web.entity;

import com.bookstore.dbentity.Book;

public class OrderBook extends Book {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "count=" + count +
                '}';
    }
}
