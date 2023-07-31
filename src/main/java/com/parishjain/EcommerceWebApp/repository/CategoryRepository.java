package com.parishjain.EcommerceWebApp.repository;

import com.parishjain.EcommerceWebApp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> getCategoryById(Integer id);
}
