package com.lji.mwohaemukji.controller;

import com.lji.mwohaemukji.controller.base.BaseController;
import com.lji.mwohaemukji.model.dto.FoodInsertDto;
import com.lji.mwohaemukji.model.response.ApiResponse;
import com.lji.mwohaemukji.service.FoodService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Food
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@RestController
@RequiredArgsConstructor
public class FoodController extends BaseController {

    private final FoodService foodService;

    @PostMapping("/food")
    public ResponseEntity<ApiResponse> insertFoodService(@RequestBody FoodInsertDto foodInsertDto) {
        return responseApi(foodService.insertFoodInformation(foodInsertDto));
    }

}
