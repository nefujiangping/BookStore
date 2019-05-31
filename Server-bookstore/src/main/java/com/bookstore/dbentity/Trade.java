package com.bookstore.dbentity;

import java.util.Date;

public class Trade {
    private Integer tradeId;

    private String userId;

    private Date tradeTime;

    private Float tradeAmount;

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Float getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Float tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tradeId=").append(tradeId);
        sb.append(", userId=").append(userId);
        sb.append(", tradeTime=").append(tradeTime);
        sb.append(", tradeAmount=").append(tradeAmount);
        sb.append("]");
        return sb.toString();
    }
}