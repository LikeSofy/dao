package com.sofy.book.reader;

import com.sofy.book.model.entity.Book;
import com.sofy.book.model.entity.Cover;
import com.sofy.book.exception.FileReadException;
import com.sofy.book.model.reader.BookReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookReaderTest {
    final String PATH = "data\\books.txt";

    BookReader bookReader;
    List<Book> books;

    @BeforeClass
    public void init() {
        bookReader = new BookReader();
    }

    @BeforeMethod
    public void fillArray() {
        books = new ArrayList<>();
        books.add(new Book("Book1", new String[]{"Book1Author1", "Book1Author2"}, "publishingHouse1", 2000, 200, new BigDecimal(500), Cover.HARD));
        books.add(new Book("Book2", new String[]{"Book2Author"}, "publishingHouse2", 2005, 300, new BigDecimal(500), Cover.HARD));
        books.add(new Book("Book3", new String[]{"Book3Author1", "Book3Author2", "Book3Author3"}, "publishingHouse3", 2000, 300, new BigDecimal(500), Cover.HARD));
        books.add(new Book("Book4", new String[]{"Book4Author"}, "publishingHouse4", 2007, 210, new BigDecimal(700), Cover.SOFT));
        books.add(new Book("Book5", new String[]{"Book5Author"}, "publishingHouse5", 2010, 220, new BigDecimal(500), Cover.HARD));
        books.add(new Book("Book6", new String[]{"Book6Author"}, "publishingHouse6", 2015, 200, new BigDecimal(900), Cover.SOFT));
        books.add(new Book("Book7", new String[]{"Book7Author"}, "publishingHouse7", 2009, 250, new BigDecimal(500), Cover.HARD));
        books.add(new Book("Book8", new String[]{"Book8Author"}, "publishingHouse8", 2012, 290, new BigDecimal(500), Cover.HARD));
        books.add(new Book("Book9", new String[]{"Book9Author"}, "publishingHouse9", 2008, 200, new BigDecimal(600), Cover.SOFT));
        books.add(new Book("Book10", new String[]{"Book10Author"}, "publishingHouse10", 2007, 200, new BigDecimal(510), Cover.HARD));
    }

    @Test
    public void testCreatePatientList() throws FileReadException {
        File file = new File(PATH);
        List<Book> actual = bookReader.createPatientList(file);
        List<Book> expected = books;
        Assert.assertEquals(actual, expected);
    }
}