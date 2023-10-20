package org.pedalhub.pedalhubbackend.services;

import org.pedalhub.pedalhubbackend.entities.Category;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.pedalhub.pedalhubbackend.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Could not find category with id=" + categoryId));

    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category addCategory(Category newCategory) {

        Category addCategory = new Category();

        if (newCategory.getParentId() != 0)
            addCategory.setParentCategory(this.findById(newCategory.getParentId()));

        addCategory.setName(newCategory.getName().toLowerCase().trim());
        addCategory.setDescription(newCategory.getDescription().toLowerCase().trim());

        return categoryRepository.save(addCategory);
    }
}
