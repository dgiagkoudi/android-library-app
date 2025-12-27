package com.example.mylibrary;

public class Book {
    private String title;
    private String writer;
    private String desc;

    public Book( String t, String w, String d){
        title=t;
        writer=w;
        desc=d;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getDescription() {
        return desc;
    }

    public boolean hasName(String b) {
        return title.equals(b);
    }
}
