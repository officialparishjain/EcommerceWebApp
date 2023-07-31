package com.parishjain.EcommerceWebApp.repository;

import com.parishjain.EcommerceWebApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> getProductById(Long id);

    List<Product> findAllByCategory_Id(Integer id);
}
