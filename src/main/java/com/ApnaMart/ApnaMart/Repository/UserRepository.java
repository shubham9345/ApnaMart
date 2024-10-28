package com.ApnaMart.ApnaMart.Repository;

import com.ApnaMart.ApnaMart.Model.Order;
import com.ApnaMart.ApnaMart.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

}
