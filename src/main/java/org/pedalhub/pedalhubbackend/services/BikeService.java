package org.pedalhub.pedalhubbackend.services;

import org.pedalhub.pedalhubbackend.entities.Bike;
import org.pedalhub.pedalhubbackend.repositories.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private BikeRepository bikeRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public List<Bike> findAll() {
        return bikeRepository.findAll();
    }
}
