package com.sofy.book.service;

import com.sofy.book.model.entity.Book;
import com.sofy.book.model.entity.Cover;
import com.sofy.book.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface BookDaoService {
    boolean contains(List<Book> books, Book book);

    boolean contains(List<Book> books, List<Book> booksIn);

    List<Book> findAll();

    void add(Book book) throws DaoException;

    void add(List<Book> books) throws DaoException;

    void delete(Book book) throws DaoException;

    void editName(Book book, String name) throws DaoException;

    void editAuthors(Book book, String[] authors) throws DaoException;

    void editPublishingHouse(Book book, String publishingHouse) throws DaoException;

    void editPublishingYear(Book book, Integer publishingYear) throws DaoException;

    void editNumberPages(Book book, Integer numberPages) throws DaoException;

    void editPrice(Book book, BigDecimal price) throws DaoException;

    void editCover(Book book, Cover cover) throws DaoException;
}
