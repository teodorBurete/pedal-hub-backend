package org.pedalhub.pedalhubbackend.controllers;

import org.pedalhub.pedalhubbackend.entities.advanced_search.req_body.BikeSearchDto;
import org.pedalhub.pedalhubbackend.entities.bikes.Bike;
import org.pedalhub.pedalhubbackend.entities.bikes.dto.BikeRequest;
import org.pedalhub.pedalhubbackend.entities.bikes.dto.BikeResponse;
import org.pedalhub.pedalhubbackend.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    private BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping()
    public Page<BikeResponse> findAll(@RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "50") Integer size,
                                      @RequestParam(defaultValue = "id") String sortBy) {

        return bikeService.findAll(page, size, sortBy);
    }

    @PostMapping("/search")
    public Page<BikeResponse> searchBikes(@RequestParam(defaultValue = "0") Integer page,
                                          @RequestParam(defaultValue = "50") Integer size,
                                          @RequestParam(defaultValue = "id") String sortBy,
                                          @RequestBody BikeSearchDto bikeSearchDto) {

        return bikeService.searchBikes(page, size, sortBy, bikeSearchDto);

    }

    @GetMapping("/{id}")
    public Bike getById(@PathVariable(value = "id") Long id) {
        return (bikeService.findById(id));
    }

    @PostMapping
    public Bike addBike(@RequestBody BikeRequest bikeRequest) throws MethodArgumentNotValidException, NoSuchMethodException {
        return bikeService.add(bikeRequest);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteBike(@PathVariable(value = "id") Long id) {
        bikeService.delete(id);
        HashMap<String, Object> res = new HashMap<>();
        res.put("message","accepted");
        res.put("success", true);
        res.put("status code",HttpStatus.OK);
        return ResponseEntity.ok(res);
    }

        /*@GetMapping("/brand/{brandName}")
    public List<Bike> getByBrandName(@PathVariable(value = "brandName") String brandName) {
        return bikeService.findByBrandName(brandName);
    }*/

   /* @GetMapping("/category/{categoryName}/year/{year}")
    public List<Bike> getBikeByCategoryAndYear(@PathVariable(value = "categoryName") String categoryName, @PathVariable(value = "year") Integer year) {
        return bikeService.findByCategoryAndYear(categoryName, year);
    }*/
}
