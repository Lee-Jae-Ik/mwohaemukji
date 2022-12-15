package com.lji.mwohaemukji.service;

import com.lji.mwohaemukji.model.dto.FoodInsertDto;

/**
 * FoodService
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
public interface FoodService {

    String insertFoodInformation(FoodInsertDto foodInsertDto);
}
