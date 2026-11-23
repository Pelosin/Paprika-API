package com.paprika.api.repo;

import com.paprika.api.domain.Order;
import com.paprika.api.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> getByStatus(OrderStatus status);
}
