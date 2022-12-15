package com.lji.mwohaemukji.model.dto;

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

    private String foodName;
    private Float foodKilocalories;
}
