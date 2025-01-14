package com.ApnaMart.ApnaMart.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long order_id;
    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    // @JsonManagedReference  // To manage the serialization correctly
    private List<Product> products;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private Date orderDate;
}





