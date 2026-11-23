package com.paprika.api.service;

import com.paprika.api.domain.Category;
import com.paprika.api.domain.Food;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();

    Category addFoodToCategory(Long id, Food food);
}
