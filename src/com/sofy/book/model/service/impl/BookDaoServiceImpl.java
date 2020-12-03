package com.sofy.book.model.service.impl;

import com.sofy.book.model.dao.impl.BookImpl;
import com.sofy.book.model.entity.Book;
import com.sofy.book.model.entity.Cover;
import com.sofy.book.exception.BookDaoServiceException;
import com.sofy.book.exception.DaoException;

import java.math.BigDecimal;
import java.util.*;

public class BookDaoServiceImpl {
    private static BookImpl instanceBookDao = BookImpl.getInstanceBookWarehouse();

    public List<Book> findAll() {
        return instanceBookDao.findAll();
    }

    public void add(Book book) throws BookDaoServiceException {
        try {
            instanceBookDao.add(book);
        }
        catch (DaoException exception){
            throw new BookDaoServiceException(exception);
        }
    }

    public void add(List<Book> books) throws BookDaoServiceException {
        try {
            instanceBookDao.add(books);
        }
        catch (DaoException exception){
            throw new BookDaoServiceException(exception);
        }
    }

    public void delete(Book book) throws BookDaoServiceException {
        try {
            instanceBookDao.delete(book);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }
    }

    public void delete(int index) throws BookDaoServiceException {
        try {
            instanceBookDao.delete(index);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }
    }

    public void editName(int index, String name) throws BookDaoServiceException {
        try {
            instanceBookDao.editName(index, name);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }
    }

    public void editAuthors(int index, String[] authors) throws BookDaoServiceException {
        try {
            instanceBookDao.editAuthors(index, authors);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }
    }

    public void editPublishingHouse(int index, String publishingHouse) throws BookDaoServiceException {
        try {
            instanceBookDao.editPublishingHouse(index, publishingHouse);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }
    }

    public void editPublishingYear(int index, Integer publishingYear) throws BookDaoServiceException {
        try {
            instanceBookDao.editPublishingYear(index, publishingYear);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }

    }

    public void editNumberPages(int index, Integer numberPages) throws BookDaoServiceException {
        try {
            instanceBookDao.editNumberPages(index, numberPages);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }

    }

    public void editPrice(int index, BigDecimal price) throws BookDaoServiceException {
        try {
            instanceBookDao.editPrice(index, price);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }

    }

    public void editCover(int index, Cover cover) throws BookDaoServiceException {
        try {
            instanceBookDao.editCover(index, cover);
        } catch (DaoException exception) {
            throw new BookDaoServiceException(exception);
        }

    }

    public List<Book> findByNameSortByPublishingHouseYear(String name){
        List<Book> books = instanceBookDao.findByName(name);
        books = sortByPublishingHouseYear(books);
        return books;
    }

    public List<Book> findByNameSortByPriceYear(String name){
        List<Book> books = instanceBookDao.findByName(name);
        books = sortByPriceYear(books);
        return books;
    }

    public void clear(){
        instanceBookDao.clear();
    }

    private List<Book> sortByPublishingHouseYear(List<Book> booksIn){
        List<Book> books = new ArrayList<>(booksIn);
        Comparator<Book> bookComparator;
        bookComparator = Comparator.comparing(Book::getPublishingHouse)
        .thenComparing(Book::getPublishingYear);
        Collections.sort(books, bookComparator);

        return books;
    }

    private List<Book> sortByPriceYear(List<Book> booksIn){
        List<Book> books = new ArrayList<>(booksIn);
        Comparator<Book> bookComparator;
        bookComparator = Comparator.comparing(Book::getPrice)
                .thenComparing(Book::getPublishingYear);
        Collections.sort(books, bookComparator);

        return books;
    }
}
