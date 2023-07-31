package com.parishjain.EcommerceWebApp.controller;

import com.parishjain.EcommerceWebApp.service.CategoryService;
import com.parishjain.EcommerceWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @GetMapping({"/","/home"})
    public String getHome(){
        return "index";
    }

    @GetMapping(value = "/shop")
    public String shop(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProducts());
        return "shop";
    }

    @GetMapping(value = "shop/category/{id}")
    public String getProductByCategoryId(Model model, @PathVariable Integer id){
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProductsByCategoryId(id));
        return "shop";
    }

    @GetMapping(value = "/shop/viewproduct/{id}")
    public String getProductById(@PathVariable Long id,Model model){
        model.addAttribute("product",productService.getProductById(id).get());
        return "viewProduct";
    }

}
