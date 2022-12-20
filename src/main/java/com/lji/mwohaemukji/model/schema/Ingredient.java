package com.lji.mwohaemukji.model.schema;

import com.lji.mwohaemukji.model.schema.Nutrients;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Ingredient
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/16
 */
@Data
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "ingredient")
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "ingredient_amount")
    private String ingredientAmount;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Nutrients> nutrientsList;

    @Column(name = "is_test")
    private Boolean isTest;
}
