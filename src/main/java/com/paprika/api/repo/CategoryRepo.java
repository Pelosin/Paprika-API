package com.paprika.api.repo;

import com.paprika.api.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    public Category save(Category foodCategory);
    public Optional<Category> findById(Long id);
}
