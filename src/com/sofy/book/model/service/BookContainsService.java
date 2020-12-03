package com.sofy.book.model.service;

import com.sofy.book.model.entity.Book;

import java.util.List;

public class BookContainsService {
    public boolean contains(List<Book> books, Book book) {
        boolean contains = false;
        int i = 0;
        while (i < books.size()) {
            if (books.get(i).equals(book)) {
                contains = true;
                break;
            }
            i++;
        }
        return contains;
    }

    public boolean contains(List<Book> books, List<Book> booksIn) {
        boolean contains = false;
        int i = 0;
        while (i < books.size()) {
            int j = 0;
            while (j < booksIn.size()){
                if (books.get(i).equals(booksIn.get(j))) {
                    contains = true;
                    break;
                }
                j++;
            }
            if (contains){
                break;
            }
            i++;
        }
        return contains;
    }
}
