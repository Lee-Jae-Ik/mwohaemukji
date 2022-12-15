package com.lji.mwohaemukji.repository;

import com.lji.mwohaemukji.model.schema.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * FoodRepository
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
