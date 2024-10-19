package com.ApnaMart.ApnaMart.Service;

import com.ApnaMart.ApnaMart.Model.Product;
import com.ApnaMart.ApnaMart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product AddProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> ProductById(Long prodId) {
        return productRepository.findById(prodId);
    }

    public List<Product> AllProducts() {
        return productRepository.findAll();
    }

    public void DeleteProductById(Long prodId) {
        if (productRepository.existsById(prodId)) {
            productRepository.deleteById(prodId);
        } else {
            throw new RuntimeException("Product not found with ID: " + prodId);
        }
    }

    public Product UpdateProduct(Long productId, Product updatedProduct) {
        Optional<Product> existingProductOpt = productRepository.findById(productId);

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();

            // Update the product's fields with the new values
            existingProduct.setImageUrl(updatedProduct.getImageUrl());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQty(updatedProduct.getQty());
            existingProduct.setRating(updatedProduct.getRating());
            existingProduct.setDiscountPrice(updatedProduct.getDiscountPrice());
            //  existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setTitle(updatedProduct.getTitle());

            // Save the updated product
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with ID: " + productId);
        }
    }
}