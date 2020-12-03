package com.sofy.book.model.dao;

import com.sofy.book.model.entity.Book;
import com.sofy.book.model.entity.Cover;
import com.sofy.book.exception.DaoException;

import java.math.BigDecimal;
import java.util.List;

public interface BookDao {
    List<Book> findAll();

    Book find(int index) throws DaoException;

    List<Book> findByName(String name);

    void add(Book book) throws DaoException;

    void add(List<Book> books) throws DaoException;

    void delete(Book book) throws DaoException;

    void delete(int index) throws DaoException;

    void editName(int index, String name) throws DaoException ;

    void editAuthors(int index,String[] authors) throws DaoException ;

    void editPublishingHouse(int index, String publishingHouse) throws DaoException ;

    void editPublishingYear(int index, Integer publishingYear) throws DaoException ;

    void editNumberPages(int index, Integer numberPages) throws DaoException ;

    void editPrice(int index, BigDecimal price) throws DaoException ;

    void editCover(int index, Cover cover) throws DaoException ;

    int length();

    void clear();
}
