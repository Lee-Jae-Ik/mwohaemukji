package com.lji.mwohaemukji.service;

import com.lji.mwohaemukji.model.dto.FoodInsertDto;
import com.lji.mwohaemukji.model.schema.Food;
import com.lji.mwohaemukji.model.schema.Ingredient;
import com.lji.mwohaemukji.model.schema.Nutrients;
import com.lji.mwohaemukji.repository.FoodRepository;
import com.lji.mwohaemukji.repository.NutrientsRepository;
import com.lji.mwohaemukji.service.impl.FoodServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * FoodServiceTest
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/18
 */
@SpringBootTest
public class FoodServiceTest {
    @InjectMocks
    private FoodService foodService;

    @Mock
    private FoodRepository foodRepository;

    @Mock
    private NutrientsRepository nutrientsRepository;

    @Test
    public void 음식_생성(FoodInsertDto foodInsertDto) {
        //given
        Food insertFood = Food.builder()
                .foodName(foodInsertDto.getFoodName())
                .foodKilocalories(foodInsertDto.getFoodKilocalories())
                .ingredientList(foodInsertDto.getIngredientList().stream()
                        .map(ingredientDto -> Ingredient.builder()
                                .ingredientName("단백질")
                                .ingredientAmount("25g")
                                .nutrientsList(ingredientDto.getNutrientsList().stream()
                                        .map(nutrientsInsertDto -> nutrientsRepository.findNutrientsByNutrientsName(ingredientDto.getIngredientName()))
                                        .toList())
                                .build())
                        .toList())
                .build();
        //when

        //then
    }
}
