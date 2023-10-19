package org.pedalhub.pedalhubbackend.controllers;

import org.modelmapper.ModelMapper;
import org.pedalhub.pedalhubbackend.entities.Category;
import org.pedalhub.pedalhubbackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Category> findAll() {
        List<Category> categories = categoryService.findAll();
        return categories;
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable(value = "id") Long id) {
        return categoryService.findById(id);
    }

}
