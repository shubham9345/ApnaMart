package com.ApnaMart.ApnaMart.Repository;

import com.ApnaMart.ApnaMart.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT o FROM Order o WHERE o.user.user_id = :userId")
    List<Order> findOrderByUserId( Long userId);
}
