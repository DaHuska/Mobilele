package org.softuni.mobilele.repository;

import org.softuni.mobilele.model.entity.Brand;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
//    @Query("SELECT b FROM Brand b JOIN FETCH b.models")
    @EntityGraph(
            value = "brandWithModels",
            attributePaths = "models"
    )
    @Query("SELECT b FROM Brand b")
    List<Brand> getAllBrands();
}
