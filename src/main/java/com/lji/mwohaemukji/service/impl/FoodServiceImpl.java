package com.lji.mwohaemukji.service.impl;

import com.lji.mwohaemukji.model.dto.FoodInsertDto;
import com.lji.mwohaemukji.repository.FoodRepository;
import com.lji.mwohaemukji.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public String insertFoodInformation(FoodInsertDto foodInsertDto) {

        

        return null;
    }
}
