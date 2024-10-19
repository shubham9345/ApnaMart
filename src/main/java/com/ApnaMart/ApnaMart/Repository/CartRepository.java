package com.ApnaMart.ApnaMart.Repository;

import com.ApnaMart.ApnaMart.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
