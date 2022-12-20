package com.lji.mwohaemukji.repository;

import com.lji.mwohaemukji.model.schema.Nutrients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NutrientsRepository
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/18
 */
@Repository
public interface NutrientsRepository extends JpaRepository<Nutrients, Long> {
    Nutrients findNutrientsByNutrientsName(String nutrientsName);
    List<Nutrients> findNutrientsByDefaultCalIsNotNull();
}
