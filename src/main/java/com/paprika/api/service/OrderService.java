package com.paprika.api.service;

import com.paprika.api.domain.Order;
import com.paprika.api.domain.OrderStatus;
import com.paprika.api.payload.request.OrderCreateRequest;
import com.paprika.api.payload.response.OrderHistoryResponse;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order saveOrder(OrderCreateRequest orderCreateRequest);
    Optional<Order> findOrderById(Long id);
    void deleteOrderById(Long id);
    List<Order> getAllOrders();
    List<Order> getAllOrdersByStatus(OrderStatus orderStatus);
    List<OrderHistoryResponse> getOrderFromUser(String username);
    void updateOrderStatus(Long id);
}
