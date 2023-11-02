package org.pedalhub.pedalhubbackend.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.entities.advanced_search.BikeSearchDto;
import org.pedalhub.pedalhubbackend.entities.dto.bikedto.BikeDto;
import org.pedalhub.pedalhubbackend.entities.dto.bikedto.BikeRequest;
import org.pedalhub.pedalhubbackend.entities.dto.bikedto.BikeResponse;
import org.pedalhub.pedalhubbackend.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public Page<Bike> findAll(@RequestParam(defaultValue = "0") Integer page,
                              @RequestParam(defaultValue = "50") Integer size,
                              @RequestParam(defaultValue = "id") String sortBy) {
        Page<Bike> bikes = bikeService.findAll(page, size, sortBy);
        return bikes;
    }

    @PostMapping("/search")
    public Page<Bike> searchBikes(@RequestParam(defaultValue = "0") Integer page,
                                  @RequestParam(defaultValue = "50") Integer size,
                                  @RequestParam(defaultValue = "id") String sortBy,
                                  @RequestBody BikeSearchDto bikeSearchDto) {

        Page<Bike> bikes = bikeService.searchBikes(page,size,sortBy,bikeSearchDto);
        return bikes;

    }

/*    @GetMapping("/{id}")
    public BikeResponse getById(@PathVariable(value = "id") Long id) {
        return this.convertToResponse(bikeService.findById(id));
    }*/

    @GetMapping("/{id}")
    public Bike getById(@PathVariable(value = "id") Long id) {
        return (bikeService.findById(id));
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
    public Bike addBike(@RequestBody BikeRequest bikeRequest) throws MethodArgumentNotValidException, NoSuchMethodException {
        return bikeService.add(bikeRequest);
    }

    private BikeDto convertToDto(Bike bike) {
        BikeDto dto = modelMapper.map(bike, BikeDto.class);
        return dto;
    }

    private BikeResponse convertToResponse(Bike bike) {
        return modelMapper.map(bike, BikeResponse.class);
    }
}
