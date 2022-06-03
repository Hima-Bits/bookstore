package com.example.bookstore.Model;

public class UpdateModel {
    private Book book;
    private String key;

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "UpdateModel{" +
                "book=" + book +
                ", key='" + key + '\'' +
                '}';
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
