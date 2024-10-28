package com.ApnaMart.ApnaMart.Repository;


import com.ApnaMart.ApnaMart.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> , PagingAndSortingRepository<Product,Long> {
    Page<Product> findAll(Pageable pageable);
}