package com.ApnaMart.ApnaMart.Repository;


import com.ApnaMart.ApnaMart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> {
}