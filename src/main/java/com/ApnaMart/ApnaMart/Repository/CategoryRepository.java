package com.ApnaMart.ApnaMart.Repository;

import com.ApnaMart.ApnaMart.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepository extends JpaRepository<Category,Long> {
}
