package com.bookstore.controller;


import com.bookstore.service.AuthorService;
import com.bookstore.web.entity.AuthorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @CrossOrigin
    @RequestMapping(value = "/api/getAuthorInfo", produces = "application/json; charset:UTF-8")
    public AuthorInfo getAuthorInfo(@RequestParam(value="authorId") int authorId){
        return authorService.getAuthorInfo(authorId);
    }
}
