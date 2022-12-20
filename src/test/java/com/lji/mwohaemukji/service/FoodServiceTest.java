package com.lji.mwohaemukji.service;

import com.lji.mwohaemukji.model.dto.FoodInsertDto;
import com.lji.mwohaemukji.model.dto.IngredientInsertDto;
import com.lji.mwohaemukji.model.dto.NutrientsInsertDto;
import com.lji.mwohaemukji.model.schema.Food;
import com.lji.mwohaemukji.model.schema.Ingredient;
import com.lji.mwohaemukji.model.schema.Nutrients;
import com.lji.mwohaemukji.repository.FoodRepository;
import com.lji.mwohaemukji.repository.IngredientRepository;
import com.lji.mwohaemukji.repository.NutrientsRepository;
import com.lji.mwohaemukji.service.impl.FoodServiceImpl;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FoodServiceTest
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/18
 */
@SpringBootTest
@ActiveProfiles("local")
public class FoodServiceTest {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private NutrientsRepository nutrientsRepository;

    @AfterEach
    public void testAfterDataDelete() {
        Food deleteFood = foodRepository.findFoodByFoodNameAndIsTest("닭가슴살테스트",true);
        foodRepository.delete(deleteFood);

        Ingredient deleteIngredient = ingredientRepository.findIngredientByIngredientNameAndIsTest("단백질테스트", true);
        ingredientRepository.delete(deleteIngredient);
    }

    @Test
    @Order(1)
    public void 음식_생성() {
        //given
        FoodInsertDto foodInsertDto = FoodInsertDto.builder()
                .foodName("닭가슴살테스트")
                .foodKilocalories(254.4F)
                .ingredientList(List.of(IngredientInsertDto.builder()
                        .ingredientName("단백질테스트")
                        .ingredientAmount("25g")
                        .nutrientsList(List.of(NutrientsInsertDto.builder()
                                .nutrientDescription("테스트")
                                .nutrientPrecautions("테스트2")
                                .nutrientsName("단백질")
                                .build()))
                        .build()))
                .build();

        List<Nutrients> nutrientsList = nutrientsRepository.findAll();

        Food insertFood = Food.builder()
                .foodName(foodInsertDto.getFoodName())
                .foodKilocalories(foodInsertDto.getFoodKilocalories())
                .isTest(true)
                .ingredientList(foodInsertDto.getIngredientList().stream()
                        .map(ingredientDto -> Ingredient.builder()
                                .ingredientName(ingredientDto.getIngredientName())
                                .ingredientAmount(ingredientDto.getIngredientAmount())
                                .isTest(true)
                                .nutrientsList(nutrientsList.stream()
                                        .filter(nutrients -> nutrients.getNutrientsName().equals(ingredientDto.getIngredientName()))
                                        .collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
        //when
        ingredientRepository.saveAll(insertFood.getIngredientList());
        foodRepository.save(insertFood);
        Food findFood = foodRepository.findFoodByFoodNameAndIsTest("닭가슴살테스트", true);
        //then
        Assertions.assertEquals(insertFood.getFoodName(), findFood.getFoodName());
        Assertions.assertEquals(insertFood.getIngredientList().get(0).getIngredientName(), insertFood.getIngredientList().get(0).getIngredientName());

    }
}
