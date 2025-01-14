package com.ApnaMart.ApnaMart.Controller;

import com.ApnaMart.ApnaMart.Model.Cart;
import com.ApnaMart.ApnaMart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/Add-Cart")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.AddCart(cart);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        Cart cart = cartService.cartById(id).orElseThrow(() -> new UsernameNotFoundException("product not found exception"));
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/All-Cart")
    public List<Cart> getAllCart() {
        return cartService.AllCart();
    }

    @PostMapping("/addProduct/{cartId}/{productId}")
    public ResponseEntity<String> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        try {
            cartService.addProductToCart(cartId, productId);
            return ResponseEntity.ok("Product added to cart successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
