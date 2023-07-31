package com.parishjain.EcommerceWebApp.service;

import com.parishjain.EcommerceWebApp.models.Category;
import com.parishjain.EcommerceWebApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }


    public void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }


    public Optional<Category> getByCategoryId(Integer id) {
        return categoryRepository.getCategoryById(id);
    }
}
