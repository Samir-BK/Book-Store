package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository CategoryRepository) {
	return (args) -> {

		Category category1 = CategoryRepository.save(new Category("AI")) ;
		Category category2 = CategoryRepository.save(new Category("Cloud"));
		Category category3 = CategoryRepository.save(new Category("Cyber Security"));
		Category category4 = CategoryRepository.save(new Category("Quantum Computing"));
		Category category5 = CategoryRepository.save(new Category("Software Engineering"));


		repository.save(new Book("Artificial Intelligence in Practice", "Maya Chen", 2026, "9781000000001", 24.99, category1));
		repository.save(new Book("Cloud Native Architecture", "Liam Johnson", 2026, "9781000000002", 29.99, category2));
		repository.save(new Book("Cybersecurity for Everyone", "Ava Williams", 2026, "9781000000003", 22.99, category3));
		repository.save(new Book("The Future of Quantum Computing", "Noah Patel", 2026, "9781000000004", 31.99, category4));
		repository.save(new Book("Sustainable Software Engineering", "Sofia Garcia", 2026, "9781000000005", 26.99, category5));
	};
}
}	
