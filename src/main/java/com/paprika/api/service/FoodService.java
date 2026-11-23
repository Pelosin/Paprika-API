package com.paprika.api.service;

import com.paprika.api.domain.Food;
import com.paprika.api.payload.response.FoodResponse;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    List<FoodResponse> getAllFood();
    Food saveFood(Food food);
    void deleteFoodById(Long id);
    Food findById(Long id);
    void changeImage(Long id, String url);
}
