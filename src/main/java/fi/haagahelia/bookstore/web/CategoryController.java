
package fi.haagahelia.bookstore.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories/add")  
    @PreAuthorize("hasRole('ADMIN')")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/categories/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveCategory(@RequestParam String name) {
        if (name == null || name.isBlank()) {
            return "redirect:/categories/add";
        }

        categoryRepository.save(new Category(name.trim()));
        return "redirect:/add";
    }
}
