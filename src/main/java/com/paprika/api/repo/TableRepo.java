package com.paprika.api.repo;

import com.paprika.api.domain.TbTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepo extends JpaRepository<TbTable ,Long> {
    TbTable findByTableNumber(String tableNumber);
}
