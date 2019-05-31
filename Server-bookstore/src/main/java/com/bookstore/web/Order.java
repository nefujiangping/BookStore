package com.bookstore.web;

import com.bookstore.web.entity.OrderBook;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class Order {
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @NotEmpty(message = "用户名不能为空")
    private String userId;

    private List<OrderBook> books;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    private int totalCount;

    private float totalMon;

    public List<OrderBook> getBooks() {
        return books;
    }

    public void setBooks(List<OrderBook> books) {
        this.books = books;
    }

    public float getTotalMon() {
        return totalMon;
    }

    public void setTotalMon(float totalMon) {
        this.totalMon = totalMon;
    }

    @Override
    public String toString() {
        return "Order{" +
                "books=" + books +
                ", totalMon=" + totalMon +
                '}';
    }
}
