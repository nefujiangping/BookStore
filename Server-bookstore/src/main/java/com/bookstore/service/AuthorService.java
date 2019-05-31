package com.bookstore.service;

import com.bookstore.dbentity.Author;
import com.bookstore.dbentity.AuthorExample;
import com.bookstore.dbentity.SimpleBookExample;
import com.bookstore.mapper.AuthorMapper;
import com.bookstore.mapper.BookMapper;
import com.bookstore.web.entity.AuthorInfo;
import com.bookstore.web.entity.FEBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorService {

    @Autowired
    AuthorMapper authorMapper;

    @Autowired
    BookMapper bookMapper;

    List<FEBook> getAuthorTopSaleBooks(int authorId, int topN){
        SimpleBookExample example = new SimpleBookExample();
        example.setAuthorId(authorId);
        example.setLimit(topN);
        return bookMapper.selectTopSaleBook(example);
    }

    Author getAuthor(int authorId){
        AuthorExample example = new AuthorExample();
        example.createCriteria().andAuthorIdEqualTo(authorId);
        return authorMapper.selectByExampleWithBLOBs(example).get(0);
    }

    public AuthorInfo getAuthorInfo(int authorId){
        Author author = this.getAuthor(authorId);
        List<FEBook> books = this.getAuthorTopSaleBooks(authorId, 5);
        AuthorInfo info = new AuthorInfo(author, books);
        return info;
    }
}
