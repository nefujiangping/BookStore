package com.bookstore.web.entity;

import com.bookstore.dbentity.BookWithBLOBs;

public class FEBook extends BookWithBLOBs{

    private String authorName;

    private String publisherName;

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }
}
