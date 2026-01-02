package com.example.mylibrary;

public class Book {
    private String title;
    private String writer;
    private String category;
    private String description;

    public Book( String title, String writer, String category, String description){
        this.title=title;
        this.writer=writer;
        this.category=category;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
}