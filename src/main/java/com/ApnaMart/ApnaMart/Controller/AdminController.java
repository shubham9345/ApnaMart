package com.ApnaMart.ApnaMart.Controller;

import com.ApnaMart.ApnaMart.Model.Order;
import com.ApnaMart.ApnaMart.Model.Product;
import com.ApnaMart.ApnaMart.Model.User;
import com.ApnaMart.ApnaMart.Service.OrderService;
import com.ApnaMart.ApnaMart.Service.ProductService;
import com.ApnaMart.ApnaMart.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome to the Admin Dashboard!";
    }

    @GetMapping("/All-User")
    public List<User> getAllUser() {
        return userService.AllUser();
    }

    @GetMapping("/All-Order")
    public List<Order> getAllOrder() {
        return orderService.AllOrder();
    }

    @GetMapping("/All-Product")
    public List<Product> getAllProducts() {
        return productService.allProduct();
    }

}