package com.sofy.book.model.dao.impl;

import com.sofy.book.model.dao.BookDao;
import com.sofy.book.exception.DaoException;
import com.sofy.book.model.dao.storage.BookWarehouse;
import com.sofy.book.model.entity.Book;
import com.sofy.book.model.entity.Cover;
import com.sofy.book.model.service.BookContainsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.List;

public class BookImpl implements BookDao {
    private static final Logger logger = LogManager.getLogger();
    private static BookImpl instance;
    private final static BookWarehouse instanceBookWarehouse = BookWarehouse.getInstance();

    private BookImpl() {
    }

    public static BookImpl getInstanceBookWarehouse() {
        if (instance == null) {
            instance = new BookImpl();
        }
        return instance;
    }

    @Override
    public List<Book> findAll() {
        return BookWarehouse.getInstance().findAll();
    }

    @Override
    public Book find(int index) throws DaoException {
        if (index < 0 || index >= findAll().size()) {
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        return instanceBookWarehouse.find(index);
    }

    @Override
    public List<Book> findByName(String name) {
        return instanceBookWarehouse.findByName(name);
    }

    @Override
    public void add(Book book) throws DaoException {
        BookContainsService service = new BookContainsService();
        if (service.contains(instanceBookWarehouse.findAll(), book)) {
            logger.error("The object already exists in the list");
            throw new DaoException("The object already exists in the list");
        }
        if (book == null){
            throw new DaoException("Null object");
        }
        instanceBookWarehouse.add(book);
    }

    @Override
    public void add(List<Book> books) throws DaoException {
        BookContainsService service = new BookContainsService();
        if (service.contains(instanceBookWarehouse.findAll(), books)) {
            logger.error("The object already exists in the list");
            throw new DaoException("The object already exists in the list");
        }
        if (books == null && books.size() == 0 && books.isEmpty()){
            logger.error("Null list");
            throw new DaoException("Null list");
        }
        instanceBookWarehouse.add(books);
    }

    @Override
    public void delete(Book book) throws DaoException {
        BookContainsService service = new BookContainsService();
        if (!service.contains(instanceBookWarehouse.findAll(), book)) {
            logger.error("The object already exists in the list");
            throw new DaoException("The object already exists in the list");
        }
        instanceBookWarehouse.delete(book);
    }

    @Override
    public void delete(int index) throws DaoException {
        if (index < 0 || index >= findAll().size()) {
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        instanceBookWarehouse.delete(index);
    }

    @Override
    public void editName(int index, String name) throws DaoException {
        if (index < 0 || index > instanceBookWarehouse.length()){
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        instanceBookWarehouse.find(index).setName(name);
    }


    @Override
    public void editAuthors(int index, String[] authors) throws DaoException {
        if (index < 0 || index > instanceBookWarehouse.length()){
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        instanceBookWarehouse.findAll().get(index).setAuthors(authors);
    }

    @Override
    public void editPublishingHouse(int index, String publishingHouse) throws DaoException {
        if (index < 0 || index > instanceBookWarehouse.length()){
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        instanceBookWarehouse.findAll().get(index).setPublishingHouse(publishingHouse);
    }

    @Override
    public void editPublishingYear(int index, Integer publishingYear) throws DaoException {
        if (index < 0 || index > instanceBookWarehouse.length()){
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        instanceBookWarehouse.findAll().get(index).setPublishingYear(publishingYear);
    }

    @Override
    public void editNumberPages(int index, Integer numberPages) throws DaoException {
        if (index < 0 || index > instanceBookWarehouse.length()){
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        instanceBookWarehouse.findAll().get(index).setNumberPages(numberPages);
    }

    @Override
    public void editPrice(int index, BigDecimal price) throws DaoException {
        if (index < 0 || index > instanceBookWarehouse.length()){
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        instanceBookWarehouse.findAll().get(index).setPrice(price);
    }

    @Override
    public void editCover(int index, Cover cover) throws DaoException {
        if (index < 0 || index > instanceBookWarehouse.length()){
            logger.error("Index out from range");
            throw new DaoException("Index out from range");
        }
        instanceBookWarehouse.findAll().get(index).setCover(cover);
    }

    @Override
    public int length(){
        return instanceBookWarehouse.length();
    }

    @Override
    public void clear(){
        instanceBookWarehouse.findAll().clear();
    }
}
