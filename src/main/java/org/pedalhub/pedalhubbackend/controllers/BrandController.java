package org.pedalhub.pedalhubbackend.controllers;

import org.modelmapper.ModelMapper;
import org.pedalhub.pedalhubbackend.entities.Brand;
import org.pedalhub.pedalhubbackend.entities.dto.BrandDto;
import org.pedalhub.pedalhubbackend.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/brands")
public class BrandController {

    private BrandService brandService;
    private ModelMapper modelMapper;

    @Autowired
    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BrandDto> getAll() {
        List<Brand> brands = brandService.findAll();
        return brands.stream().map(this::converToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable(value = "id") Long id) {
        return brandService.findById(id);
    }

    @PostMapping
    public Brand newBrand(@RequestBody Brand newBrand) {
        return brandService.save(newBrand);
    }

    private BrandDto converToDto(Brand brand) {
        BrandDto dto = modelMapper.map(brand, BrandDto.class);
        return dto;
    }
}
