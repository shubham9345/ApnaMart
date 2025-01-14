package com.ApnaMart.ApnaMart.Repository;


import com.ApnaMart.ApnaMart.Model.CategoryType;
import com.ApnaMart.ApnaMart.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> , PagingAndSortingRepository<Product,Long> {
    Page<Product> findAll(Pageable pageable);
    List<Product> findBytypeOfProduct(CategoryType categoryType);
}