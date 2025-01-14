package com.ApnaMart.ApnaMart.Service;

import com.ApnaMart.ApnaMart.Model.Cart;
import com.ApnaMart.ApnaMart.Model.Product;
import com.ApnaMart.ApnaMart.Repository.CartRepository;
import com.ApnaMart.ApnaMart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    public Cart AddCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> cartById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    public List<Cart> AllCart() {
        return cartRepository.findAll();
    }

    public void addProductToCart(Long cartId, Long productId) {
        // Fetch the cart by ID
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        if (cartOptional.isEmpty()) {
            throw new RuntimeException("Cart not found with ID: " + cartId);
        }
        Cart cart = cartOptional.get();

        // Fetch the product by ID
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found with ID: " + productId);
        }
        Product product = productOptional.get();

        // Add the product to the cart
        if (!cart.getProducts().contains(product)) {
            cart.getProducts().add(product);
        }

        // Save the updated cart
        cartRepository.save(cart);
    }
}
