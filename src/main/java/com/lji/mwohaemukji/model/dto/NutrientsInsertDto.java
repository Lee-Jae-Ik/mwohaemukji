package com.lji.mwohaemukji.model.dto;

import lombok.*;

/**
 * NutrientsInsertDto
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/18
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class NutrientsInsertDto {

    private Long ingredientId;
    private String nutrientsName;
    private String nutrientDescription;
    private String nutrientPrecautions;
}
