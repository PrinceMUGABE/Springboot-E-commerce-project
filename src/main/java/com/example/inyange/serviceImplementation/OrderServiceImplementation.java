package com.example.inyange.serviceImplementation;

import com.example.inyange.model.OrderModel;
import com.example.inyange.repository.OrderRepository;
import com.example.inyange.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImplementation implements OrderService {
    @Autowired
    OrderRepository repo;
    @Override
    public OrderModel saveOrder(OrderModel order) {
        return repo.save(order);
    }

    @Override
    public List<OrderModel> displayOrders() {
        return repo.findAll();
    }

    @Override
    public OrderModel findOrderById(OrderModel order) {
        return repo.findById(order.getId()).orElse(null);
    }

    @Override
    public OrderModel updateOrder(OrderModel order) {
        OrderModel savedOrder = repo.findById(order.getId()).orElse(null);
        if (savedOrder!=null){
            savedOrder.setFullnames(order.getFullnames());
            savedOrder.setPhone(order.getPhone());
            savedOrder.setAddress(order.getAddress());
            return  repo.save(savedOrder);
        }
        return repo.save(order);
    }

    @Override
    public void deleteOrder(OrderModel order) {
        OrderModel savedOrder = repo.findById(order.getId()).orElse(null);
        if (savedOrder!=null){
            repo.delete(savedOrder);
        }

    }
}
