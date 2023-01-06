package com.lji.mwohaemukji.util;

import com.lji.mwohaemukji.model.schema.Food;
import com.lji.mwohaemukji.model.schema.Ingredient;
import com.lji.mwohaemukji.model.schema.Nutrients;
import com.lji.mwohaemukji.repository.FoodRepository;
import com.lji.mwohaemukji.repository.IngredientRepository;
import com.lji.mwohaemukji.repository.NutrientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UtilService
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2023/01/02
 */
@Service
public class UtilService {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    NutrientsRepository nutrientsRepository;

    @Transactional
    public Nutrients createNutrients() {

        Nutrients nutrients = Nutrients.builder()
                .nutrientsName("단백질")
                .defaultCal(4F)
                .nutrientsDescription("단백질은 근육 향상에 도움이 됩니다.")
                .nutrientsPrecautions("단백질 과다 섭취 혈압을 낮출 수 있으며, 체중이 증가하며, 소화불량을 겪을 수 있습니다.")
                .build();

        nutrientsRepository.save(nutrients);

        return nutrients;
    }

    @Transactional
    public void deleteNutrients(Long id) {
        nutrientsRepository.deleteById(id);
    }

    @Transactional
    public Ingredient createIngredient(Nutrients nutrients) {
        Ingredient ingredient = Ingredient.builder()
                .ingredientName("단백질")
                .ingredientAmount("50g")
                .nutrientsList(Collections.singletonList(nutrients))
                .build();

        ingredientRepository.save(ingredient);

        return ingredient;
    }

    @Transactional
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Transactional
    public Food createFood(Ingredient ingredient) {
        List<Nutrients> nutrientsList = nutrientsRepository.findNutrientsByDefaultCalIsNotNull();

        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredient);

        List<Float> calList = new ArrayList<>();
        nutrientsList.forEach(nutrients -> {
            Float cal = ingredientList.stream().filter(ingredientData -> ingredientData.getIngredientName().equals(nutrients.getNutrientsName()))
                    .map(i -> nutrients.getDefaultCal() * Float.parseFloat(i.getIngredientAmount().substring(0, (i.getIngredientAmount().endsWith("kg")
                            ? i.getIngredientAmount().lastIndexOf("kg") : i.getIngredientAmount().lastIndexOf("g"))))).findAny().get();
            calList.add(cal);
        });


        Food food = Food.builder()
                .foodName("닭가슴살")
                .ingredientList(Collections.singletonList(ingredient))
                .foodKilocalories((float) calList.stream().mapToInt(Float::intValue).sum())
                .build();
        foodRepository.save(food);

        return food;
    }

    @Transactional
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
