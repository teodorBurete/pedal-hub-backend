package org.pedalhub.pedalhubbackend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.modelmapper.ModelMapper;
import org.pedalhub.pedalhubbackend.entities.categories.Category;
import org.pedalhub.pedalhubbackend.entities.categories.dto.CategoryRequest;
import org.pedalhub.pedalhubbackend.entities.categories.jsonviews.View;
import org.pedalhub.pedalhubbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    private ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    @JsonView(View.CategoryView.List.class)
    public List<Category> findAll() {
        List<Category> categories = categoryService.findAll();
        return categories;
    }

    @GetMapping("/{id}")
    @JsonView(View.CategoryView.Single.class)

    public Category getById(@PathVariable(value = "id") Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody CategoryRequest newCategory) {
        return categoryService.addCategory(newCategory);
    }
}
