package com.example.bookstore.Model;

public class Book {
    private long id;

    @Override
    public String toString() {
        return "Book [Id=" + id + ", " +
                "BookName=" + bookName +
                ", AuthorName=" + authorName +
                ", description=" + description +
                ", price=" + price +
                ", publisher=" + publisher + "]";
    }

    private String bookName;
    private String authorName;
    private String description;
    private String price;
    private String publisher;

    public Book() {

    }

    public Book(Book b, long id) {
        this.authorName = b.authorName;
        this.bookName = b.bookName;
        this.description = b.description;
        this.price = b.price;
        this.publisher = b.publisher;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
