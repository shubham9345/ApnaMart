package com.ApnaMart.ApnaMart.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prod_id;
    private String imageUrl;
    private String title;
    private String description;
    private Long price;
    private Long discountPrice;
    private int qty;
    private double rating;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Order> order;
    @ManyToMany
    @JoinTable(
            name = "cart_product", // Name of the join table
            joinColumns = @JoinColumn(name = "product_id"), // Foreign key to the Cart entity
            inverseJoinColumns = @JoinColumn(name = "cart_id") // Foreign key to the Product entity
    )
    @JsonIgnore
    private List<Cart> carts ;
    @Enumerated(EnumType.STRING)
    private CategoryType typeOfProduct;
}
