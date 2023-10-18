package org.pedalhub.pedalhubbackend.controllers;

import org.pedalhub.pedalhubbackend.entities.Brand;
import org.pedalhub.pedalhubbackend.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/brands")
public class BrandController {

    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getAll() {
        return brandService.findAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable(value = "id") Long id) {
        return brandService.findById(id);
    }

    @PostMapping
    public Brand newBrand(@RequestBody Brand newBrand) {
        return brandService.save(newBrand);
    }
}
