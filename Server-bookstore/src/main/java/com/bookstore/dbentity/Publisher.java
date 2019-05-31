package com.bookstore.dbentity;

public class Publisher {
    private Integer publisherId;

    private String publisherName;

    private String publisherIntro;

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName == null ? null : publisherName.trim();
    }

    public String getPublisherIntro() {
        return publisherIntro;
    }

    public void setPublisherIntro(String publisherIntro) {
        this.publisherIntro = publisherIntro == null ? null : publisherIntro.trim();
    }
}