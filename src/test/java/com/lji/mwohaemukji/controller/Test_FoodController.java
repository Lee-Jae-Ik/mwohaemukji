package com.lji.mwohaemukji.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lji.mwohaemukji.model.schema.Food;
import com.lji.mwohaemukji.model.schema.Ingredient;
import com.lji.mwohaemukji.model.schema.Nutrients;
import com.lji.mwohaemukji.repository.FoodRepository;
import com.lji.mwohaemukji.repository.IngredientRepository;
import com.lji.mwohaemukji.repository.NutrientsRepository;
import com.lji.mwohaemukji.util.UtilService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test_FoodController
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2023/01/02
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class Test_FoodController {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    NutrientsRepository nutrientsRepository;

    @Autowired
    IngredientRepository ingredientRepository;


    static Long NUTRIENTS_ID;
    static Long INGREDIENT_ID;
    static Long FOOD_ID;

    @BeforeAll
    public static void setUp(@Autowired UtilService utilService) {
        Nutrients nutrients = utilService.createNutrients();
        NUTRIENTS_ID = nutrients.getNutrientsId();

        Ingredient ingredient = utilService.createIngredient(nutrients);
        INGREDIENT_ID = ingredient.getIngredientId();

        Food food = utilService.createFood(ingredient);
        FOOD_ID = food.getFoodId();

    }

    @AfterAll
    public static void cleanUp(@Autowired UtilService utilService) {
        utilService.deleteFood(FOOD_ID);
        utilService.deleteIngredient(INGREDIENT_ID);
        utilService.deleteNutrients(NUTRIENTS_ID);
    }

    @Test
    @Order(1)
    void 음식_생성_성공() {

    }

}
