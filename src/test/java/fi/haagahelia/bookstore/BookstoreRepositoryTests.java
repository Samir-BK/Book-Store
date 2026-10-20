package fi.haagahelia.bookstore;    

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.domain.UserRepository;



@DataJpaTest
public class BookstoreRepositoryTests {

    @Autowired 
    private BookRepository bookRepository;

    @Autowired 
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;


    // Book Repository Test

    /**
     * Test case to verify that a new Book can be persisted in the database.
     */
    @Test 
    public void createNewBook() {
        Category category = new Category("Sci-fi");
        categoryRepository.save(category);

        Book book = new Book("Dune", "Frank Herbert", 1990, "890-789797", 30.99, category);
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
    } 
}
