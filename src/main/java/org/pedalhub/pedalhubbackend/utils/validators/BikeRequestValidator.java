package org.pedalhub.pedalhubbackend.utils.validators;

import org.pedalhub.pedalhubbackend.entities.dto.bikedto.BikeRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class BikeRequestValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return BikeRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "name", "name.empty", "name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "brandId", "brandId.empty", "brandId is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "categoryId", "categoryId.empty", "categoryId is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "groupsetId", "groupsetId.empty", "groupsetId is required");



        BikeRequest b = (BikeRequest) target;
        if (b.getPrice()<0||b.getPrice()>9999)
            e.rejectValue("price", "incorrect.price", "price should be between 0 and 100000");
        if(b.getYear()<1900||b.getYear()> LocalDate.now().getYear())
            e.rejectValue("year", "incorrect.year", "year should be between 1900 and current year");

    }
}
