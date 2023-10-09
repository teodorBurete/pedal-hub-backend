package org.pedalhub.pedalhubbackend.services;

import org.pedalhub.pedalhubbackend.entities.Brand;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.pedalhub.pedalhubbackend.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find brand with id=" + id));
    }

    public Brand save(Brand newBrand) {

        Brand brand = new Brand(
                newBrand.getName(),
                newBrand.getDescription(),
                newBrand.getCountry()
        );
        return brandRepository.save(brand);
    }

}
