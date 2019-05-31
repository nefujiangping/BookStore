package com.bookstore.dbentity;

public class BookWithBLOBs extends Book {
    private String description;

    private byte[] image;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}