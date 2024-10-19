package com.ApnaMart.ApnaMart.Service;

import com.ApnaMart.ApnaMart.Model.Cart;
import com.ApnaMart.ApnaMart.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart AddCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> cartById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    public List<Cart> AllCart() {
        return cartRepository.findAll();
    }
}
