package com.ApnaMart.ApnaMart.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cart")
public class Cart {
    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;
    @OneToOne
    @JoinColumn(name = "user_Id", nullable = false)
//    @JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(
            name = "cart_product", // Name of the join table
            joinColumns = @JoinColumn(name = "cart_id"), // Foreign key to the Cart entity
            inverseJoinColumns = @JoinColumn(name = "product_id") // Foreign key to the Product entity
    )
    private List<Product> products;

    public Cart(Long cart_id) {
        this.cart_id=cart_id;
    }
}
