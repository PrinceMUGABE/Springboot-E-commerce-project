package com.example.inyange.service;

import com.example.inyange.model.OrderModel;

import java.util.List;

public interface OrderService {
    OrderModel saveOrder(OrderModel order);
    List<OrderModel> displayOrders();
    OrderModel findOrderById(OrderModel order);
    OrderModel updateOrder(OrderModel order);
    void deleteOrder(OrderModel order);
}
