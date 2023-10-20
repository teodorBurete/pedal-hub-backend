package org.pedalhub.pedalhubbackend.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.pedalhub.pedalhubbackend.utils.validators.BikeRequestValidator;
import org.pedalhub.pedalhubbackend.utils.validators.BrandValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }

    @Bean
    public BrandValidator brandValidator() {
        return new BrandValidator();
    }

    @Bean
    public BikeRequestValidator bikeValidator() {
        return new BikeRequestValidator();
    }


}
