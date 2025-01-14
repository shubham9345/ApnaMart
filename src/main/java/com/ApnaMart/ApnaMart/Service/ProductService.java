package com.ApnaMart.ApnaMart.Service;

import com.ApnaMart.ApnaMart.Model.CategoryType;
import com.ApnaMart.ApnaMart.Model.Product;
import com.ApnaMart.ApnaMart.Model.Review;
import com.ApnaMart.ApnaMart.Model.User;
import com.ApnaMart.ApnaMart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Product> getProducts(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort;

        // Support multiple sorting options
        switch (sortBy) {
            case "price":
                sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                        ? Sort.by("price").ascending()
                        : Sort.by("price").descending();
                break;
            case "category":
                sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                        ? Sort.by("category").ascending()
                        : Sort.by("category").descending();
                break;
            default:
                sort = Sort.by("price").ascending();  // Default sorting
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findAll(pageable);
    }

    public List<Product>allProduct(){
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
    public List<Product> getProductType(CategoryType categoryType){
        List<Product> productList = productRepository.findBytypeOfProduct(categoryType);
        return productList;
    }
    public List<Review>AllReviewsByProdId(Long prodId){
        Optional<Product> product = productRepository.findById(prodId);
        if (product.isEmpty()) {
            throw new RuntimeException("product not found with ID: " + prodId);
        }
        Product prod = product.get();
        List<Review> reviews = prod.getReviews();
        return reviews;
    }
}