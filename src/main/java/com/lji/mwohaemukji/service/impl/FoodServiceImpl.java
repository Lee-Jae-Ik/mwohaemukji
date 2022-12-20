package com.lji.mwohaemukji.service.impl;

import com.lji.mwohaemukji.model.dto.FoodInsertDto;
import com.lji.mwohaemukji.model.schema.Food;
import com.lji.mwohaemukji.model.schema.Ingredient;
import com.lji.mwohaemukji.model.schema.Nutrients;
import com.lji.mwohaemukji.repository.FoodRepository;
import com.lji.mwohaemukji.repository.IngredientRepository;
import com.lji.mwohaemukji.repository.NutrientsRepository;
import com.lji.mwohaemukji.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FoodServiceImpl
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@RequiredArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final IngredientRepository ingredientRepository;
    private final NutrientsRepository nutrientsRepository;

    @Transactional
    @Override
    public String insertFoodInformation(FoodInsertDto foodInsertDto) {

        List<Nutrients> nutrientsList = nutrientsRepository.findAll();

        Food insertFood = Food.builder()
                .foodName(foodInsertDto.getFoodName())
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

        if (foodInsertDto.getFoodKilocalories() == null) {
            insertFood.setFoodKilocalories(calculateFoodKilocalories(insertFood.getIngredientList()));
        } else {
            insertFood.setFoodKilocalories(foodInsertDto.getFoodKilocalories());
        }

        ingredientRepository.saveAll(insertFood.getIngredientList());
        foodRepository.save(insertFood);

        return "success";
    }

    private Float calculateFoodKilocalories(List<Ingredient> ingredientList) {
        List<Nutrients> nutrientsList = nutrientsRepository.findNutrientsByDefaultCalIsNotNull();

        List<Float> floatList = new ArrayList<>();
        nutrientsList.forEach(nutrients -> {
            Float cal = ingredientList.stream().filter(ingredient -> ingredient.getIngredientName().equals(nutrients.getNutrientsName()))
                    .map(i -> nutrients.getDefaultCal() * Float.parseFloat(i.getIngredientAmount().substring(0, (i.getIngredientAmount().endsWith("kg")
                            ? i.getIngredientAmount().lastIndexOf("kg") : i.getIngredientAmount().lastIndexOf("g"))))).findAny().get();

            floatList.add(cal);
        });

        return (float) floatList.stream().mapToInt(Float::intValue).sum();
    }
}
