package com.bookstore.controller;


import com.bookstore.dbentity.Publisher;
import com.bookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @CrossOrigin
    @RequestMapping(value = "/api/getPublisherInfo", produces = "application/json; charset:UTF-8")
    public Publisher getAuthorInfo(@RequestParam(value="publisherId") int publisherId){
        return publisherService.getPublisherInfo(publisherId);
    }
}
