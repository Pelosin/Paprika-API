package com.paprika.api.repo;


import com.paprika.api.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Long> {
    public Food findByName(String name);
}
