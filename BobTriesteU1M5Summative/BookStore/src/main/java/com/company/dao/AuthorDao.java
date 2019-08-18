package com.company.dao;

import com.company.model.Author;
import com.company.model.Book;

import java.util.List;

public interface AuthorDao {

    Author getAuthor(int id);

    List<Author> getAllAuthors();

    Author addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(int id);


}