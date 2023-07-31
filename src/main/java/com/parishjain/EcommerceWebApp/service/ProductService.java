package com.parishjain.EcommerceWebApp.service;

import com.parishjain.EcommerceWebApp.models.Product;
import com.parishjain.EcommerceWebApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void removeProductById(Long id){
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.getProductById(id);
    }

    // used for sorting
    public List<Product> getAllProductsByCategoryId(Integer id){
        return productRepository.findAllByCategory_Id(id);
    }
}
