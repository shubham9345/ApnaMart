package com.ApnaMart.ApnaMart.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cart")
public class Cart {
    @Id
    private Long cart_id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    // Foreign key for User entity
    // @JsonManagedReference
    private User user;

    @ManyToMany
    @JoinTable(
            name = "cart_product", // Name of the join table
            joinColumns = @JoinColumn(name = "cart_id"), // Foreign key to the Cart entity
            inverseJoinColumns = @JoinColumn(name = "product_id") // Foreign key to the Product entity
    )
    private List<Product> products;
}
