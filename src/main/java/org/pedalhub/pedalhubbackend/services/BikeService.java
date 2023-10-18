package org.pedalhub.pedalhubbackend.services;

import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.entities.dto.BikeDto;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.pedalhub.pedalhubbackend.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private BikeRepository bikeRepository;
    private BrandService brandService;
    private CategoryService categoryService;
    private GroupsetService groupsetService;

    @Autowired
    public BikeService(BikeRepository bikeRepository, BrandService brandService, CategoryService categoryService, GroupsetService groupsetService) {
        this.bikeRepository = bikeRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.groupsetService = groupsetService;
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

  /*  public Bike add(BikeDto bikeDto) {

        Bike newBike = new Bike();

        newBike.setName(bikeDto.getName());
        newBike.setYear(bikeDto.getYear());
        newBike.setPrice(bikeDto.getPrice());
        newBike.setBrand(brandService.findById(bikeDto.getBrandId()));
        newBike.setCategory(categoryService.findById(bikeDto.getCategoryId()));
        newBike.setGroupset(groupsetService.findById(bikeDto.getGroupsetId()));
        newBike.setBrakesType(bikeDto.getBrakesType());
        newBike.setFrameMaterial(bikeDto.getFrameMaterial());
        newBike.setSuspensionType(bikeDto.getSuspensionType());

        return bikeRepository.save(newBike);
    }*/
}
