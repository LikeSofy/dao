package com.sofy.book.model.service.impl;

import com.sofy.book.exception.BookDaoServiceException;
import com.sofy.book.model.entity.Book;
import com.sofy.book.model.entity.Cover;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookDaoServiceImplTest {
    ArrayList<Book> booksList;
    BookDaoServiceImpl service;

    @BeforeClass
    public void init() {
        service = new BookDaoServiceImpl();
    }

    @BeforeGroups("addDelete")
    public void fillArray() {
        booksList = new ArrayList<>();
        booksList.add(new Book("Book1", new String[]{"Book1Author1", "Book1Author2"}, "publishingHouse1", 2000, 200, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book2", new String[]{"Book2Author"}, "publishingHouse2", 2005, 300, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book3", new String[]{"Book3Author1", "Book3Author2", "Book3Author3"}, "publishingHouse3", 2000, 300, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book4", new String[]{"Book4Author"}, "publishingHouse4", 2007, 210, new BigDecimal(700), Cover.SOFT));
        booksList.add(new Book("Book5", new String[]{"Book5Author"}, "publishingHouse5", 2010, 220, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book6", new String[]{"Book6Author"}, "publishingHouse6", 2015, 200, new BigDecimal(900), Cover.SOFT));
        booksList.add(new Book("Book7", new String[]{"Book7Author"}, "publishingHouse7", 2009, 250, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book8", new String[]{"Book8Author"}, "publishingHouse8", 2012, 290, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book9", new String[]{"Book9Author"}, "publishingHouse9", 2008, 200, new BigDecimal(600), Cover.SOFT));
        booksList.add(new Book("Book10", new String[]{"Book10Author"}, "publishingHouse10", 2007, 200, new BigDecimal(510), Cover.HARD));
    }

    @BeforeGroups("editing")
    public void fillArrayDao() {
        booksList = new ArrayList<>();
        booksList.add(new Book("Book1", new String[]{"Book1Author1", "Book1Author2"}, "publishingHouse1", 2000, 200, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book2", new String[]{"Book2Author"}, "publishingHouse2", 2005, 300, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book3", new String[]{"Book3Author1", "Book3Author2", "Book3Author3"}, "publishingHouse3", 2000, 300, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book4", new String[]{"Book4Author"}, "publishingHouse4", 2007, 210, new BigDecimal(700), Cover.SOFT));
        booksList.add(new Book("Book5", new String[]{"Book5Author"}, "publishingHouse5", 2010, 220, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book6", new String[]{"Book6Author"}, "publishingHouse6", 2015, 200, new BigDecimal(900), Cover.SOFT));
        booksList.add(new Book("Book7", new String[]{"Book7Author"}, "publishingHouse7", 2009, 250, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book8", new String[]{"Book8Author"}, "publishingHouse8", 2012, 290, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book9", new String[]{"Book9Author"}, "publishingHouse9", 2008, 200, new BigDecimal(600), Cover.SOFT));
        booksList.add(new Book("Book10", new String[]{"Book10Author"}, "publishingHouse10", 2007, 200, new BigDecimal(510), Cover.HARD));
        service.clear();
        try {
            service.add(booksList);
        } catch (BookDaoServiceException exception) {
            exception.printStackTrace();
        }
    }

    @BeforeGroups("search")
    public void fillArrayDaoForSearchTest() {
        booksList = new ArrayList<>();
        booksList.add(new Book("Book", new String[]{"Book1Author1", "Book1Author2"}, "publishingHouse1", 2000, 200, new BigDecimal(500), Cover.HARD));
        booksList.add(new Book("Book", new String[]{"Book2Author"}, "publishingHouse2", 2005, 300, new BigDecimal(200), Cover.HARD));
        booksList.add(new Book("Book", new String[]{"Book3Author1", "Book3Author2", "Book3Author3"}, "publishingHouse2", 2000, 300, new BigDecimal(100), Cover.HARD));
        booksList.add(new Book("Book4", new String[]{"Book4Author"}, "publishingHouse4", 2007, 210, new BigDecimal(700), Cover.SOFT));
        booksList.add(new Book("Book5", new String[]{"Book5Author"}, "publishingHouse5", 2010, 220, new BigDecimal(500), Cover.HARD));
        service.clear();
        try {
            service.add(booksList);
        } catch (BookDaoServiceException exception) {
            exception.printStackTrace();
        }
    }

    @Test(groups = "addDelete")
    public void AddListTest() {
        try {
            service.add(booksList);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "addDelete")
    public void addTest() {
        Book book = new Book("Book11", new String[]{"Book11Author"}, "publishingHouse11", 2007, 200, new BigDecimal(510), Cover.HARD);
        try {
            service.add(book);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        List<Book> expected = booksList;
        expected.add(book);
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "addDelete")
    public void deleteByIndex(){
        int index = 10;
        try {
            service.delete(index);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.remove(10);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "addDelete")
    public void deleteTest(){
        Book book = new Book("Book10", new String[]{"Book10Author"}, "publishingHouse10", 2007, 200, new BigDecimal(510), Cover.HARD);
        try {
            service.delete(book);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.remove(book);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);

    }

    @Test(groups = "editing")
    public void testEditName() {
        String customName = "Custom Name";
        try {
            service.editName(0, customName);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.get(0).setName(customName);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "editing")
    public void testEditAuthors() {
        String[] customAuthors = new String[]{"Custom author"};
        try {
            service.editAuthors(0, customAuthors);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.get(0).setAuthors(customAuthors);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "editing")
    public void testEditPublishingHouse() {
        String customPublishingHouse = "Custom Publishing House";
        try {
            service.editPublishingHouse(0, customPublishingHouse);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.get(0).setPublishingHouse(customPublishingHouse);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "editing")
    public void testEditPublishingYear() {
        int customYear = 900;
        try {
            service.editPublishingYear(0, customYear);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.get(0).setPublishingYear(customYear);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "editing")
    public void testEditNumberPages() {
        int customNumsPages = 90;
        try {
            service.editNumberPages(0, customNumsPages);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.get(0).setNumberPages(customNumsPages);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "editing")
    public void testEditPrice() {
        BigDecimal customPrice = new BigDecimal(10);
        try {
            service.editPrice(0, customPrice);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.get(0).setPrice(customPrice);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "editing")
    public void testEditCover() {
        Cover customCover = Cover.SOFT;
        try {
            service.editCover(0, customCover);
        } catch (BookDaoServiceException exception) {
            Assert.fail();
        }
        List<Book> actual = service.findAll();
        booksList.get(0).setCover(customCover);
        List<Book> expected = booksList;
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "search")
    public void testFindByNameSortByPublishingHouseYear() {
        List<Book> actual = service.findByNameSortByPublishingHouseYear("Book");
        List<Book> expected = new ArrayList<>();
        expected.add(booksList.get(0));
        expected.add(booksList.get(2));
        expected.add(booksList.get(1));
        Assert.assertEquals(actual, expected);
    }

    @Test(groups = "search")
    public void testFindByNameSortPriceYear() {
        List<Book> actual = service.findByNameSortByPriceYear("Book");
        List<Book> expected = new ArrayList<>();
        expected.add(booksList.get(2));
        expected.add(booksList.get(1));
        expected.add(booksList.get(0));
        Assert.assertEquals(actual, expected);
    }
}