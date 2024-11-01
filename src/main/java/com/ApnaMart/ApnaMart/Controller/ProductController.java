package com.ApnaMart.ApnaMart.Controller;

import com.ApnaMart.ApnaMart.Model.Product;
import com.ApnaMart.ApnaMart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/Add-Product")
    public Product createProduct(@RequestBody Product products) {
        return productService.AddProduct(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.ProductById(id).orElseThrow(() -> new UsernameNotFoundException("product not found exception"));
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public Page<Product> getProducts(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "2") int pageSize,
            @RequestParam(defaultValue = "price") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        return productService.getProducts(pageNumber, pageSize, sortBy, sortDir);
    }
    @GetMapping("/All-Product")
    public List<Product>getAllProduct(){
        return productService.allProduct();
    }

    @DeleteMapping("/Delete-ProductById/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        try {
            productService.DeleteProductById(id);
            return ResponseEntity.ok("Product deleted successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        try {
            Product product = productService.UpdateProduct(id, updatedProduct);
            return ResponseEntity.ok(product);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

}

