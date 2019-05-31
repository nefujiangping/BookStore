package com.bookstore.controller;


import com.bookstore.web.entity.FEBook;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @CrossOrigin
    @RequestMapping(value = "/api/getTopSale", produces = "application/json; charset:UTF-8")
    public List<FEBook> getTopSaleBooks(){
        return bookService.getTopSaleBooks(9);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getBookInfo", produces = "application/json; charset:UTF-8")
    public FEBook getBookInfo(@RequestParam(value="isbn") String isbn){
        return bookService.getBookInfo(isbn);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/search", produces = "application/json; charset:UTF-8")
    public List<FEBook> search(@RequestParam(value="query", defaultValue = "人生") String query){
        return bookService.search(query);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/category", produces = "application/json; charset:UTF-8")
    public List<FEBook> getBooksByCategory(@RequestParam(value="category", defaultValue = "中国当代小说") String category){
        return bookService.getBooksByCategory(category);
    }
}
