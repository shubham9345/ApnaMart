package com.ApnaMart.ApnaMart.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true)
    //@JsonBackReference
    @JsonIgnore
    private Category category;
    @ManyToMany(mappedBy = "products")
    // @JsonBackReference   // To avoid infinite recursion in JSON
    @JsonIgnore
    private List<Order> order;
}
