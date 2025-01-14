package com.ApnaMart.ApnaMart.Service;

import com.ApnaMart.ApnaMart.Model.Cart;
import com.ApnaMart.ApnaMart.Model.Order;
import com.ApnaMart.ApnaMart.Model.User;
import com.ApnaMart.ApnaMart.Repository.CartRepository;
import com.ApnaMart.ApnaMart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CartService cartService;


    public User save(User user) {
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username is already taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        // Create and link the cart
        UUID uuid = UUID.randomUUID();
        Long idx = uuid.getMostSignificantBits() & Long.MAX_VALUE;
        Cart cart = new Cart();
        cart.setCart_id(idx);
        cart.setUser(savedUser);
        cartService.AddCart(cart);
        savedUser.setCart(cart);

        return savedUser; // Cascade saves the cart
    }


    public List<User> AllUser() {
        return userRepository.findAll();
    }

    public List<Order> findAllOrderByUserId(Long userId){
        Optional<User> UserOptional = userRepository.findById(userId);
        if (UserOptional.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }
        User user = UserOptional.get();
        if(user.getOrders().isEmpty()){
           throw new RuntimeException("order list is empty");
        }
        return user.getOrders();
    }
}
