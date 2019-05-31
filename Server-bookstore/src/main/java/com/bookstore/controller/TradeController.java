package com.bookstore.controller;

import com.bookstore.dbentity.TradeItem;
import com.bookstore.service.TradeService;
import com.bookstore.web.Order;
import com.bookstore.web.user.Result;
import com.bookstore.web.user.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class TradeController {

    @Autowired
    TradeService tradeService;

    @CrossOrigin
    @RequestMapping(value = "/api/checkout", method = RequestMethod.POST, produces = "application/json; charset:UTF-8")
    public Result checkout(@Valid @RequestBody Order order, BindingResult bindingResult){
//        System.out.println(order.getUserId());
//        for(OrderBook book: order.getBooks()){
//            System.out.println(book.getIsbn() + book.getTitle() + book.getCount());
//        }
        if (bindingResult.hasErrors()) {
            String message = String.format("订单失败，[%s]。", bindingResult.getFieldError().getDefaultMessage());
            return new Result(ResultCode.FAIL_VALUE_NULL, message, null);
        }
        return tradeService.checkOrder(order);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getTradeDetail", method = RequestMethod.GET, produces = "application/json; charset:UTF-8")
    public List<TradeItem> getTradeDetail(int tradeId){
        return tradeService.getTradeDetail(tradeId);
    }
}
