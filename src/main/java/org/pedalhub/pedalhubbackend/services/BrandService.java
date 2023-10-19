package org.pedalhub.pedalhubbackend.services;

import org.modelmapper.ModelMapper;
import org.pedalhub.pedalhubbackend.entities.Brand;
import org.pedalhub.pedalhubbackend.exceptions.ResourceNotFoundException;
import org.pedalhub.pedalhubbackend.repositories.BrandRepository;
import org.pedalhub.pedalhubbackend.utils.validators.BrandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.function.UnaryOperator;

@Service
public class BrandService {

    private BrandRepository brandRepository;
    private ModelMapper modelMapper;
    private BrandValidator brandValidator;

    @Autowired
    public BrandService(BrandRepository brandRepository, ModelMapper modelMapper, BrandValidator brandValidator) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
        this.brandValidator = brandValidator;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Could not find brand with id=" + id));
    }

    public Brand save(Brand newBrand) throws NoSuchMethodException, MethodArgumentNotValidException {
        this.validateBrand(newBrand);
        Brand b = new Brand();
        b.setName(newBrand.getName().toLowerCase());
        b.setDescription(newBrand.getDescription().toLowerCase());
        b.setCountry(b.getCountry().toLowerCase());

        return null;


    }

    private void validateBrand(Brand newBrand) throws NoSuchMethodException, MethodArgumentNotValidException {
        BindingResult bindingResult = new BeanPropertyBindingResult(newBrand, "newBrand");
        brandValidator.validate(newBrand, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(
                    new MethodParameter(this.getClass().getDeclaredMethod("validateBrand", Brand.class), 0),
                    bindingResult);
        }
    }


}
