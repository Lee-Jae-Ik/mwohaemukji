package com.lji.mwohaemukji.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

/**
 * FoodInsertDto
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class FoodInsertDto {

    @NotNull(message = "음식의 이름은 필수 값 입니다.")
    private String foodName;

    private Float foodKilocalories;

    private List<IngredientInsertDto> ingredientList;
}
