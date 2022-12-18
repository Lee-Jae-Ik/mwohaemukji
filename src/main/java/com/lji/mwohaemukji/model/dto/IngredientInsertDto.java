package com.lji.mwohaemukji.model.dto;

import com.lji.mwohaemukji.model.schema.Nutrients;
import lombok.*;

import java.util.List;

/**
 * IngredientInsertDto
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/18
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class IngredientInsertDto {

    private String ingredientAmount;
    private String ingredientName;
    private List<NutrientsInsertDto> nutrientsList;
}
