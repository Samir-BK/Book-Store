package fi.haagahelia.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
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

    /**
     * Test case to verify search functionality
     */
    @Test
    public void findByTitleShouldReturnBook() {
        // Arrange: Prepare test data in the in-memory database
        Category category = categoryRepository.save(new Category("Horor"));
        bookRepository.save(new Book("Test Title", "Author", 2025, "89800", 8.0, category));

        // Act: Find the book by title using the available repository method
        List<Book> books = bookRepository.findByTitle("Test Title");

        // Assert: Verify search results match expectations

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Author");
    }

    /*
    * Test Case to verify that a book can be deleted
    */
   @Test
   public void deleteBook() {
    Category category = categoryRepository.save(new Category("Drama"));
    Book book = bookRepository.save(new Book("ToDelete", "Author", 2020, "78797", 10, category));

    bookRepository.delete(book);

    Optional<Book> deletedBook = bookRepository.findById(book.getId());
    assertThat(deletedBook).isEmpty();
   }

   /*
    Test case to verify category creategory creation and ID auto-generation
   */

    @Test
    public void cretateNewCategoryTest() {
        Category category = categoryRepository.save(new Category("Sc-fi"));


        assertThat(category.getCategoryid()).isNotNull();
    }
}
