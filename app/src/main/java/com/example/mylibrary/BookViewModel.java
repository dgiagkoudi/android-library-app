package com.example.mylibrary;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class BookViewModel extends ViewModel {

    private List<Book> books;
    private Book selectedBook;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setSelectedBook(Book book) {
        this.selectedBook = book;
    }

    public Book getSelectedBook() {
        return selectedBook;
    }
}