package org.pedalhub.pedalhubbackend.repositories;

import org.pedalhub.pedalhubbackend.entities.brands.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {


}
