package com.sofy.book.model.dao.storage;

import com.sofy.book.model.entity.Book;
import com.sofy.book.exception.DaoException;

import java.util.ArrayList;
import java.util.List;

public class BookWarehouse{

    private static BookWarehouse instance;
    private List<Book> books = new ArrayList<>();

    private BookWarehouse() {
    }

    public static BookWarehouse getInstance() {
        if (instance == null) {
            instance = new BookWarehouse();
        }
        return instance;
    }

    public List<Book> findAll() {
        return books;
    }

    public Book find(int index) {
        return books.get(index);
    }

    public List<Book> findByName(String name){
        List<Book> result = new ArrayList<Book>();
        for (int i = 0; i < length(); i++){
            if (books.get(i).getName().equals(name)){
                result.add(books.get(i));
            }
        }

        return result;
    }

    public void add(Book book) throws DaoException {
        books.add(book);
    }

    public void add(List<Book> books) throws DaoException {
        for(int i = 0; i < books.size(); i++){
            this.books.add(books.get(i));
        }
    }

    public void delete(Book book) throws DaoException {
        books.remove(book);
    }

    public void delete(int index) throws DaoException {
        books.remove(index);
    }

    public void update(int index, Book book) {
        books.remove(index);
        books.add(index, book);
    }

    public int length(){
        return books.size();
    }
}
