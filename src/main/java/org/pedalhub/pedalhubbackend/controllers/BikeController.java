package org.pedalhub.pedalhubbackend.controllers;

import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.entities.dto.BikeDto;
import org.pedalhub.pedalhubbackend.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    private BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/all")
    public List<Bike> findAll() {
        return bikeService.findAll();
    }
    @GetMapping("/{id}")
    public Bike getById(@PathVariable(value = "id")Long id){
        return bikeService.findById(id);
    }
    @GetMapping("/brand/{brandName}")
    public List<Bike> getByBrandName(@PathVariable(value = "brandName")String brandName){
        return bikeService.findByBrandName(brandName);
    }

    @GetMapping("/category/{categoryName}/year/{year}")
    public List<Bike> getBikeByCategoryAndYear(@PathVariable(value = "categoryName")String categoryName,@PathVariable(value = "year") Integer year){
        return bikeService.findByCategoryAndYear(categoryName,year);
    }

    @PostMapping
    public Bike addBike(@RequestBody BikeDto bikeDto){
        return bikeService.add(bikeDto);
    }
}
