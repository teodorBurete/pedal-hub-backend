package org.pedalhub.pedalhubbackend.repositories;

import org.pedalhub.pedalhubbackend.entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long> {

    List<Bike> findBikesByBrandName(String brandName);

    List<Bike> findBikesByCategoryNameAndYear(String categoryName, Integer year);

}
