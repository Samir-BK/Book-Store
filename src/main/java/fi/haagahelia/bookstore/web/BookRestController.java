package fi.haagahelia.bookstore.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Iterable <Book> findAllBooks () {
        return bookRepository.findAll();
    }
    @GetMapping("/books/{id}")
    public Optional<Book> findById(@PathVariable("id") Long studentId) {
        return bookRepository.findById(studentId);
    }
    
    
}
