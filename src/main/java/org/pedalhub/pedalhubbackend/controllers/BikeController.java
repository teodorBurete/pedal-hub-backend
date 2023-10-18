package org.pedalhub.pedalhubbackend.controllers;

import org.modelmapper.ModelMapper;
import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.entities.dto.BikeDto;
import org.pedalhub.pedalhubbackend.entities.dto.BikeResponse;
import org.pedalhub.pedalhubbackend.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    private BikeService bikeService;
    private ModelMapper modelMapper;

    @Autowired
    public BikeController(BikeService bikeService, ModelMapper modelMapper) {
        this.bikeService = bikeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<BikeDto> findAll() {
        List<Bike> bikes = bikeService.findAll();
        return bikes.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BikeResponse getById(@PathVariable(value = "id") Long id) {
        return this.convertToResponse(bikeService.findById(id));
    }

    @GetMapping("/brand/{brandName}")
    public List<Bike> getByBrandName(@PathVariable(value = "brandName") String brandName) {
        return bikeService.findByBrandName(brandName);
    }

    @GetMapping("/category/{categoryName}/year/{year}")
    public List<Bike> getBikeByCategoryAndYear(@PathVariable(value = "categoryName") String categoryName, @PathVariable(value = "year") Integer year) {
        return bikeService.findByCategoryAndYear(categoryName, year);
    }

    @PostMapping
    public Bike addBike(@RequestBody BikeDto bikeDto) {
        //  return bikeService.add(bikeDto);
        return null;
    }

    private BikeDto convertToDto(Bike bike) {
        BikeDto dto = modelMapper.map(bike, BikeDto.class);
        return dto;
    }

    private BikeResponse convertToResponse(Bike bike) {
        return modelMapper.map(bike, BikeResponse.class);
    }
}
