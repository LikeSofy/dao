package com.sofy.book.model.entity;

import com.sofy.book.util.IdGenerator;

import java.math.BigDecimal;
import java.util.Arrays;

public class Book {
    private int id = IdGenerator.GenerateId();
    private String name;
    private String[] authors;
    private String publishingHouse;
    private int publishingYear;
    private int numberPages;
    private BigDecimal price;
    private Cover cover;

    public Book(String name, String[] authors, String publishingHouse, int publishingYear, int numberPages, BigDecimal price, Cover cover) {
        this.name = name;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.publishingYear = publishingYear;
        this.numberPages = numberPages;
        this.price = price;
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (publishingYear != book.publishingYear) return false;
        if (numberPages != book.numberPages) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(authors, book.authors)) return false;
        if (publishingHouse != null ? !publishingHouse.equals(book.publishingHouse) : book.publishingHouse != null)
            return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        return cover == book.cover;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(authors);
        result = 31 * result + (publishingHouse != null ? publishingHouse.hashCode() : 0);
        result = 31 * result + publishingYear;
        result = 31 * result + numberPages;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", authors=").append(Arrays.toString(authors));
        sb.append(", publishingHouse='").append(publishingHouse).append('\'');
        sb.append(", publishingYear=").append(publishingYear);
        sb.append(", numberPages=").append(numberPages);
        sb.append(", price=").append(price);
        sb.append(", cover=").append(cover);
        sb.append('}');
        return sb.toString();
    }
}
