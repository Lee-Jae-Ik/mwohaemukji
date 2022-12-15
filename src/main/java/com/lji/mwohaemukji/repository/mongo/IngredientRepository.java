package com.lji.mwohaemukji.repository.mongo;

import com.lji.mwohaemukji.model.schema.mongo.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
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
public interface IngredientRepository extends MongoRepository<Ingredient, Long> {
}
