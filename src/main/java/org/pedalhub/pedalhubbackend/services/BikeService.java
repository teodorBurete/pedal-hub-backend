package org.pedalhub.pedalhubbackend.services;

import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.entities.dto.bikedto.BikeRequest;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.pedalhub.pedalhubbackend.repositories.BikeRepository;
import org.pedalhub.pedalhubbackend.utils.validators.BikeRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Service
public class BikeService {

    private BikeRepository bikeRepository;
    private BrandService brandService;
    private CategoryService categoryService;
    private GroupsetService groupsetService;
    private BikeRequestValidator bikeRequestValidator;

    @Autowired
    public BikeService(BikeRepository bikeRepository, BrandService brandService,
                       CategoryService categoryService, GroupsetService groupsetService
            , BikeRequestValidator bikeRequestValidator) {
        this.bikeRepository = bikeRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.groupsetService = groupsetService;
        this.bikeRequestValidator = bikeRequestValidator;
    }

    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }

    public Page<Bike> findAll(Integer page, Integer size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Bike> pagedResult = bikeRepository.findAll(pageable);
        return pagedResult;
        //return pagedResult.getContent();

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

    @Transactional
    public Bike add(BikeRequest bikeRequest) throws MethodArgumentNotValidException, NoSuchMethodException {

        validateBikeRequest(bikeRequest);

        Bike newBike = new Bike();
        newBike.setName(bikeRequest.getName());
        newBike.setYear(bikeRequest.getYear());
        newBike.setPrice(bikeRequest.getPrice());
        newBike.setBrand(brandService.findById(bikeRequest.getBrandId()));
        newBike.setCategory(categoryService.findById(bikeRequest.getCategoryId()));
        newBike.setGroupset(groupsetService.findById(bikeRequest.getGroupsetId()));
        newBike.setBrakesType(bikeRequest.getBrakesType());
        newBike.setFrameMaterial(bikeRequest.getFrameMaterial());
        newBike.setSuspensionType(bikeRequest.getSuspensionType());

        return bikeRepository.save(newBike);
    }

    private void validateBikeRequest(BikeRequest bikeRequest) throws NoSuchMethodException, MethodArgumentNotValidException {
        BindingResult bindingResult = new BeanPropertyBindingResult(bikeRequest, "bikeRequest");
        bikeRequestValidator.validate(bikeRequest, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(
                    new MethodParameter(this.getClass().getDeclaredMethod("validateBikeRequest", BikeRequest.class), 0),
                    bindingResult);
        }
    }


}
