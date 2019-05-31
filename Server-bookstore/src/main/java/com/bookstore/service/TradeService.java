package com.bookstore.service;

import com.bookstore.dbentity.*;
import com.bookstore.mapper.BookMapper;
import com.bookstore.mapper.TradeItemMapper;
import com.bookstore.mapper.TradeMapper;
import com.bookstore.mapper.UserMapper;
import com.bookstore.web.Order;
import com.bookstore.web.entity.OrderBook;
import com.bookstore.web.user.Result;
import com.bookstore.web.user.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TradeService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TradeMapper tradeMapper;

    @Autowired
    TradeItemMapper tradeItemMapper;

    @Autowired
    BookMapper bookMapper;


    public Result checkOrder(Order order){
        String userId = order.getUserId();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        List<User> reclledUsers = userMapper.selectByExample(userExample);
        if(reclledUsers.size() != 1){
            return new Result(ResultCode.FAIL_USER_NOT_EXIST, "用户未找到。",null);
        }
        User orderUser = reclledUsers.get(0);
        if(order.getBooks().size() > 0){
            Float totalMon = 0f;
            for(OrderBook book: order.getBooks()){
                totalMon += book.getPrice()*book.getCount();
            }
            if(!totalMon.equals(order.getTotalMon())){
                return new Result(ResultCode.FAIL_TOTAL_MONEY_NOT_MATCH, "订单总金额不匹配。",null);
            }
            Float balance = orderUser.getBalance();
            if(balance < totalMon){
                return new Result(ResultCode.FAIL_BALANCE_NOT_ENOUGH, String.format("余额不足，当前余额为：%.2f元。", balance), null);
            }
            // insert trade record
            Trade trade = new Trade();
            trade.setUserId(userId);
            trade.setTradeTime(new Date());
            trade.setTradeAmount(order.getTotalMon());
            tradeMapper.insert(trade);
            int tradeId = trade.getTradeId();
            for(OrderBook book: order.getBooks()){
                TradeItem item = new TradeItem();
                item.setTradeId(tradeId);
                item.setBookIsbn(book.getIsbn());
                item.setQuantity(book.getCount());
                item.setAmount(book.getCount() * book.getPrice());
                tradeItemMapper.insert(item);
            }
            float newBalance = balance - order.getTotalMon();
            orderUser.setBalance(newBalance);
            userMapper.updateByExample(orderUser, userExample);
            return new Result(ResultCode.SUCCESS, "支付完成", newBalance);

        }

        return new Result(ResultCode.INTERNAL_SERVER_ERROR, "订单异常。",null);

    }

    public List<TradeItem> getTradeDetail(int tradeId){
        TradeItemExample example = new TradeItemExample();
        example.createCriteria().andTradeIdEqualTo(tradeId);

        List<TradeItem> items = tradeItemMapper.selectByExample(example);
        List<String> isbnList = new ArrayList<>();
        for(TradeItem item: items){
            isbnList.add(item.getBookIsbn());
        }

        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIsbnIn(isbnList);
        List<Book> books = bookMapper.selectByExample(bookExample);
        Map<String, String> isbnTitleMap = new HashMap<>();
        for(Book book: books){
            isbnTitleMap.put(book.getIsbn(), book.getTitle());
        }
        for(int i = 0; i < items.size(); i++){
            TradeItem item = items.get(i);
            item.setTitle(isbnTitleMap.get(item.getBookIsbn()));
        }
        return items;
    }
}
