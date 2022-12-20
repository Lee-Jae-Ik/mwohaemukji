package com.lji.mwohaemukji.repository;

import com.lji.mwohaemukji.model.schema.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * IngredientRepository
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/16
 */
@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Ingredient findIngredientByIngredientNameAndIsTest(String name, Boolean isTest);
}
