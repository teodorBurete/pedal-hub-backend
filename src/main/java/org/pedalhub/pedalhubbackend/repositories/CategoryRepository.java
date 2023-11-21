package org.pedalhub.pedalhubbackend.repositories;

import org.pedalhub.pedalhubbackend.entities.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
