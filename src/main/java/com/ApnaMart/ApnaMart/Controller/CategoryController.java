package com.ApnaMart.ApnaMart.Controller;

import com.ApnaMart.ApnaMart.Model.Category;
import com.ApnaMart.ApnaMart.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/Add-Category")
    public Category createProduct(@RequestBody Category category) {
        return categoryService.AddCategory(category);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        try {
            Category category = categoryService.categoryById(id).orElseThrow(() -> new UsernameNotFoundException("category  not found exception"));
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/All-Category")
    public List<Category> getAllCategory() {
        return categoryService.AllCategory();
    }

    @DeleteMapping("/Delete-CategoryById/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.DeleteCategoryById(id);
            return ResponseEntity.ok("Category deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        try {
            Category category = categoryService.UpdateCategory(id, updatedCategory);
            return ResponseEntity.ok(category);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}

