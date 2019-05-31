package com.bookstore.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bookstore.dbentity.*;
import com.bookstore.mapper.AuthorMapper;
import com.bookstore.web.entity.FEBook;
import com.bookstore.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    AuthorMapper authorMapper;

    public List<FEBook> getTopSaleBooks(int topN){
//        BookExample example = new BookExample();
//        example.setOffset(0);
//        example.setLimit(topN);
//        example.setOrderByClause("number_sale desc");
//        return bookMapper.selectByExample(example);
        SimpleBookExample example = new SimpleBookExample();
        example.setLimit(topN);
        return bookMapper.selectTopSaleBook(example);
    }

    public List<FEBook> getBooksByCategory(String category){
        return bookMapper.selectBooksByCategory(category);
    }

    public FEBook getBookInfo(String isbn){
        return bookMapper.selectBookInfo(isbn);
    }

    public List<FEBook> search(String query){
        query = "%" + query + "%";
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andTitleLike(query);
        List<Book> booksByTitle = bookMapper.selectByExample(bookExample);

        AuthorExample authorExample = new AuthorExample();
        authorExample.createCriteria().andAuthorNameLike(query);
        List<Author> authors = authorMapper.selectByExample(authorExample);
        List<Integer> authorIds = new ArrayList<>();
        for (Author author: authors) {
            authorIds.add(author.getAuthorId());
        }
        System.out.println(authorIds.size());
        List<Book> booksByAuthorName = new ArrayList<>();
        if(authorIds.size() > 0){
            bookExample = new BookExample();
            bookExample.createCriteria().andAuthorIdIn(authorIds);
            booksByAuthorName = bookMapper.selectByExample(bookExample);
        }

        Map<String, Book> bookMap = new HashMap<>();
        authorIds = new ArrayList<>();
        for (Book book: booksByTitle) {
            if(!bookMap.containsKey(book.getIsbn())){
                bookMap.put(book.getIsbn(), book);
                authorIds.add(book.getAuthorId());
            }
        }
        for (Book book: booksByAuthorName) {
            if(!bookMap.containsKey(book.getIsbn())){
                bookMap.put(book.getIsbn(), book);
                authorIds.add(book.getAuthorId());
            }
        }

        authors = new ArrayList<>();
        if(authorIds.size() > 0) {
            authorExample = new AuthorExample();
            authorExample.createCriteria().andAuthorIdIn(authorIds);
            authors = authorMapper.selectByExample(authorExample);
        }
        Map<Integer, String> authorMap = new HashMap<>();
        for (Author author: authors){
            if(!authorMap.containsKey(author.getAuthorId())){
                authorMap.put(author.getAuthorId(), author.getAuthorName());
            }
        }

        List<FEBook> books = new ArrayList<>();
        for(Map.Entry<String, Book> bookEntry: bookMap.entrySet()){
            FEBook book = new FEBook();
            Book recalledBook = bookEntry.getValue();
            book.setIsbn(recalledBook.getIsbn());
            book.setTitle(recalledBook.getTitle());
            book.setAuthorId(recalledBook.getAuthorId());
            book.setAuthorName(authorMap.get(recalledBook.getAuthorId()));
            book.setImageSrc(recalledBook.getImageSrc());
            book.setPrice(recalledBook.getPrice());
            books.add(book);
        }
        System.out.println(books);
        return books;
    }
}
