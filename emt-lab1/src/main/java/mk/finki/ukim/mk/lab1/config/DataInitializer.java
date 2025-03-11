package mk.finki.ukim.mk.lab1.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab1.model.Author;
import mk.finki.ukim.mk.lab1.model.Book;
import mk.finki.ukim.mk.lab1.model.Country;
import mk.finki.ukim.mk.lab1.model.enumerations.Category;
import mk.finki.ukim.mk.lab1.repository.AuthorRepository;
import mk.finki.ukim.mk.lab1.repository.BookRepository;
import mk.finki.ukim.mk.lab1.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @PostConstruct
    public void init() {
        Country country1 = countryRepository.save(new Country("USA", "North America"));
        Country country2 = countryRepository.save(new Country("Canada", "North America"));

        Author author1 = authorRepository.save(new Author("Colleen", "Hoover", country1));
        Author author2 = authorRepository.save(new Author("Sarah", "Jio", country2));

        Book book1 = bookRepository.save(new Book("Verity", Category.THRILLER, author1,250));
        Book book2 = bookRepository.save(new Book("The Last Camellia", Category.NOVEL, author2, 652));
        Book book3 = bookRepository.save(new Book("November 9", Category.NOVEL, author1, 400));
        bookRepository.saveAll(List.of(book1,book2));
    }
}
