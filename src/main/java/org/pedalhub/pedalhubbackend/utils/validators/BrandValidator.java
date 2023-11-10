package org.pedalhub.pedalhubbackend.utils.validators;

import org.pedalhub.pedalhubbackend.entities.Brand;
import org.pedalhub.pedalhubbackend.entities.dto.brabddto.BrandDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BrandValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return Brand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "name", "name.empty","Name is required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "country", "country.empty","Country is required!");

        BrandDto b = (BrandDto) target;
        if (b.getDescription().length() > 600)
            e.rejectValue("description", "too.long","Description is too long!");
    }
}
