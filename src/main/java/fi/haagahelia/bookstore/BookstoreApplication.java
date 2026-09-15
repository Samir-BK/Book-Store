package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		repository.save(new Book("Artificial Intelligence in Practice", "Maya Chen", 2026, "9781000000001", 24.99));
		repository.save(new Book("Cloud Native Architecture", "Liam Johnson", 2026, "9781000000002", 29.99));
		repository.save(new Book("Cybersecurity for Everyone", "Ava Williams", 2026, "9781000000003", 22.99));
		repository.save(new Book("The Future of Quantum Computing", "Noah Patel", 2026, "9781000000004", 31.99));
		repository.save(new Book("Sustainable Software Engineering", "Sofia Garcia", 2026, "9781000000005", 26.99));
	};
}
}	
