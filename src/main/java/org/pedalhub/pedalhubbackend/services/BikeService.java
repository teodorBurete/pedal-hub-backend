package org.pedalhub.pedalhubbackend.services;

import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.entities.Groupset;
import org.pedalhub.pedalhubbackend.entities.dto.BikeDto;
import org.pedalhub.pedalhubbackend.entities.enums.bike.BrakesType;
import org.pedalhub.pedalhubbackend.entities.enums.bike.FrameMaterial;
import org.pedalhub.pedalhubbackend.entities.enums.bike.SuspensionType;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.pedalhub.pedalhubbackend.repositories.BikeRepository;
import org.pedalhub.pedalhubbackend.repositories.BrandRepository;
import org.pedalhub.pedalhubbackend.repositories.CategoryRepository;
import org.pedalhub.pedalhubbackend.repositories.GroupsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private BikeRepository bikeRepository;
    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;
    private GroupsetRepository groupsetRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository, BrandRepository brandRepository, CategoryRepository categoryRepository, GroupsetRepository groupsetRepository) {
        this.bikeRepository = bikeRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.groupsetRepository = groupsetRepository;
    }

    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    public Bike findById(Long id) {
        return bikeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find bike with id=" + id));
    }

    public List<Bike> findByBrandName(String brandName) {
        return bikeRepository.findBikesByBrandName(brandName);
    }

    public List<Bike> findByCategoryAndYear(String categoryName, Integer year) {
        return bikeRepository.findBikesByCategoryNameAndYear(categoryName, year);
    }

    public Bike add(BikeDto bikeDto) {

        Bike newBike = new Bike();

        newBike.setName(bikeDto.getName());
        newBike.setYear(bikeDto.getYear());
        newBike.setPrice(bikeDto.getPrice());
        newBike.setBrand(brandRepository.getById(bikeDto.getBrandId()));
        newBike.setCategory(categoryRepository.getById(bikeDto.getCategoryId()));
        newBike.setGroupset(groupsetRepository.getById(bikeDto.getGroupsetId()));
        newBike.setBrakesType(BrakesType.valueOf(bikeDto.getBrakesType().toUpperCase()));
        newBike.setFrameMaterial(FrameMaterial.valueOf(bikeDto.getFrameMaterial().toUpperCase()));
        newBike.setSuspensionType(SuspensionType.valueOf(bikeDto.getSuspensionType().toUpperCase()));

        return bikeRepository.save(newBike);
    }
}
