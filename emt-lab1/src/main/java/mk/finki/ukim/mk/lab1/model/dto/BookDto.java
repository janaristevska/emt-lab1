package mk.finki.ukim.mk.lab1.model.dto;

import lombok.Data;
import mk.finki.ukim.mk.lab1.model.Author;
import mk.finki.ukim.mk.lab1.model.Book;
import mk.finki.ukim.mk.lab1.model.enumerations.Category;

@Data
public class BookDto {
    private String name;

    private String category;

    private Long author;

    private Integer availableCopies;

    public BookDto(Book book) {

    }

    public BookDto(String name, String category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}
