package com.company.dao;

import com.company.model.Book;

import java.util.List;

public interface BookDao {

    Book getBook(int id);

    List<Book> getAllBooks();

    Book addBook(Book book);

    void updateBook(Book Book);

    void readBook(int id);

    void deleteBook(int id);

    List<Book> getBooksByAuthor(int author_id);

    List<Book> getBooksByTitle(String title);

}
