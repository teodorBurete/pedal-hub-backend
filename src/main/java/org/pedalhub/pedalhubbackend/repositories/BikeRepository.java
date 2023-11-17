package org.pedalhub.pedalhubbackend.repositories;

import org.pedalhub.pedalhubbackend.entities.bikes.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long>, JpaSpecificationExecutor<Bike> {

    List<Bike> findBikesByBrandName(String brandName);

    List<Bike> findBikesByCategoryNameAndYear(String categoryName, Integer year);

}
