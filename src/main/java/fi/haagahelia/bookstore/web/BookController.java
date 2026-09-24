    package fi.haagahelia.bookstore.web;

    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RestController;

    import fi.haagahelia.bookstore.domain.Book;
    import fi.haagahelia.bookstore.domain.BookRepository;
    import fi.haagahelia.bookstore.domain.CategoryRepository;

    @RestController
    public class BookController {
        private final CategoryRepository categoryRepository;
        private final BookRepository bookRepository;

        public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
            this.bookRepository = bookRepository;
            this.categoryRepository = categoryRepository;
        }

        @GetMapping("/index")   
        public String index() {
            return "index";
        }
        @GetMapping("/booklist")
        public String booklist(Model model) {
            model.addAttribute("books", bookRepository.findAll());
            return "booklist";
        }

        @GetMapping("/add")
        public String addBook(Model model) {
            model.addAttribute("book", new Book());
            model.addAttribute("categories", categoryRepository.findAll());
            return "addbook";
        }

        @PostMapping("/save")
        public String save(Book book) {
            bookRepository.save(book);
            return "redirect:booklist";
        }

        @GetMapping("/delete/{id}")
        public String deleteBook(@PathVariable("id") Long bookId) {
            bookRepository.deleteById(bookId);
            return "redirect:../booklist";
        }

        @GetMapping("/edit/{id}")
        public String editBook(@PathVariable("id") Long bookId, Model model) {
            model.addAttribute("book", bookRepository.findById(bookId).orElse(null));
            return "editbook";
        }
    }
