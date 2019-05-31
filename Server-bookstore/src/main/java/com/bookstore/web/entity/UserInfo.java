package com.bookstore.web.entity;

import com.bookstore.dbentity.Trade;
import com.bookstore.dbentity.User;

import java.util.List;

public class UserInfo {
    User user;

    List<Trade> trades;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }

    public UserInfo(User user, List<Trade> trades) {
        this.user = user;
        this.trades = trades;
    }
}
