package com.ApnaMart.ApnaMart.Service;

import com.ApnaMart.ApnaMart.Model.Order;
import com.ApnaMart.ApnaMart.Model.OrderStatus;
import com.ApnaMart.ApnaMart.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> AllOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order placeOrder(Order order) {
        order.setOrderDate(new java.util.Date());
        order.setStatus(OrderStatus.PLACED);
        return orderRepository.save(order);
    }

    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(OrderStatus.CANCELED);
        orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setProducts(orderDetails.getProducts());
        order.setOrderDate(orderDetails.getOrderDate());
        order.setStatus(orderDetails.getStatus());
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findOrderByUserId(userId);
    }

}
