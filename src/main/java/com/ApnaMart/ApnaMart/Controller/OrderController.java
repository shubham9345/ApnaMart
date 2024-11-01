package com.ApnaMart.ApnaMart.Controller;

import com.ApnaMart.ApnaMart.Model.Order;
import com.ApnaMart.ApnaMart.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/All-Order")
    public List<Order> getAllOrder() {
        return orderService.AllOrder();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> orderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return ResponseEntity.ok(order);
    }

    @PostMapping("/Place-Order")
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        orderService.placeOrder(order);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        Order order = orderService.getOrderById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return ResponseEntity.ok(order);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order updatedOrder = orderService.updateOrder(id, orderDetails);
        return ResponseEntity.ok(updatedOrder);
    }

    @GetMapping("/orderByUserId/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();  // Return 204 if no orders are found
        }
        return ResponseEntity.ok(orders);  // Return the list of orders
    }
}
