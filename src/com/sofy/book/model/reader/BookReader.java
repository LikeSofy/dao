package com.sofy.book.model.reader;

import com.sofy.book.exception.FileReadException;
import com.sofy.book.model.entity.Book;
import com.sofy.book.model.entity.Cover;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookReader {
    private static final Logger logger = LogManager.getLogger();

    public List<Book> createPatientList(File file) throws FileReadException {
        List<Book> result = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String bookLine = scanner.nextLine();
                String[] bookFields = bookLine.split(" ");
                String name = bookFields[0];
                String[] bookAuthors = bookFields[1].split(",");
                String publishingHouse = bookFields[2];
                int publishingYear = Integer.parseInt(bookFields[3]);
                int numberPages = Integer.parseInt(bookFields[4]);
                BigDecimal price = new BigDecimal(Double.parseDouble(bookFields[5]));
                Cover cover = Cover.valueOf(bookFields[6]);
                Book book = new Book(name, bookAuthors, publishingHouse, publishingYear, numberPages, price, cover);

                result.add(book);
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found: ", e);
            throw new FileReadException(e);
        } finally {
            scanner.close();
            logger.info("Read books: {}", result);
        }
        return result;
    }
}
