package com.ApnaMart.ApnaMart.Service;

import com.ApnaMart.ApnaMart.Model.Category;
import com.ApnaMart.ApnaMart.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category AddCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> categoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public List<Category> AllCategory() {
        return categoryRepository.findAll();
    }

    public void DeleteCategoryById(Long CategoryId) {
        if (categoryRepository.existsById(CategoryId)) {
            categoryRepository.deleteById(CategoryId);
        } else {
            throw new RuntimeException("Category not found with ID: " + CategoryId);
        }
    }

    public Category UpdateCategory(Long categoryId, Category updatedCategory) {
        Optional<Category> existingCategoryOpt = categoryRepository.findById(categoryId);

        if (existingCategoryOpt.isPresent()) {
            Category existingCategory = existingCategoryOpt.get();

            // Update the product's fields with the new values
            existingCategory.setCategory_id(updatedCategory.getCategory_id());
            existingCategory.setCategoryName(updatedCategory.getCategoryName());

            // Save the updated product
            return categoryRepository.save(existingCategory);
        } else {
            throw new RuntimeException("Category not found with ID: " + categoryId);
        }

    }
}
