package com.lji.mwohaemukji.model.schema.mongo;

import com.lji.mwohaemukji.model.schema.Nutrients;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Ingredient
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/16
 */
@Document
@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    private String ingredientName;

    private String ingredientAmount;

    private List<Nutrients> nutrientsList;
}
