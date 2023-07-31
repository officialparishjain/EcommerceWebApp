package com.parishjain.EcommerceWebApp.controller;

import com.parishjain.EcommerceWebApp.dto.ProductDTO;
import com.parishjain.EcommerceWebApp.models.Category;
import com.parishjain.EcommerceWebApp.models.Product;
import com.parishjain.EcommerceWebApp.service.CategoryService;
import com.parishjain.EcommerceWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

    @Autowired
    CategoryService categoryService;


    @Autowired
    ProductService productService;

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCategories(Model model){
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }


    @GetMapping("admin/categories/add")
    public String getCategory(Model model){
        model.addAttribute("category",new Category());
        return "categoriesAdd";
    }

    @PostMapping("admin/categories/add")
    public String postCategory(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping(value = "/admin/categories/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }


    @GetMapping(value = "/admin/categories/update/{id}")
    public String updateCategory(@PathVariable Integer id,Model model){

        Optional<Category> optional= categoryService.getByCategoryId(id);
        if(optional.isPresent()){
            model.addAttribute("category",optional.get());
            return "categoriesAdd";
        }
        else {
            return "404";
        }
    }


    // PRODUCTS

    @GetMapping("/admin/products")
    public String getProducts(Model model){
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }

    // adding product
    @GetMapping("/admin/products/add")
    public String addProduct(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        // Here we are sending categories also
        model.addAttribute("categories",categoryService.getAllCategory());
        return "productsAdd";
    }


    @PostMapping("admin/products/add")
    public String productPost(@ModelAttribute("productDTO") ProductDTO productDTO,
                              @RequestParam("productImage")MultipartFile file,
                              @RequestParam("imgName") String imgName) throws IOException {

        // Converting dto to product
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setWeight(productDTO.getWeight());
        product.setDescription(productDTO.getDescription());
        product.setCategory(categoryService.getByCategoryId(productDTO.getCategoryId()).get());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir,imageUUID);
            // here we are converting file to bytes because we are dealing with file
            Files.write(filePath,file.getBytes());
        }
        else {
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);
        productService.addProduct(product);


        return "redirect:/admin/products";

    }



    @GetMapping(value = "/admin/product/delete/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }


    @GetMapping(value = "/admin/product/update/{id}")
    public String updateProductById(@PathVariable Long id,Model model){

        Optional<Product> optional= productService.getProductById(id);
        if(optional.isPresent()){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(optional.get().getId());
            productDTO.setName(optional.get().getName());
            productDTO.setPrice(optional.get().getPrice());
            productDTO.setWeight(optional.get().getWeight());
            productDTO.setDescription(optional.get().getDescription());
            productDTO.setImageName(optional.get().getImageName());
            productDTO.setCategoryId(optional.get().getCategory().getId());
            model.addAttribute("categories",categoryService.getAllCategory());
            model.addAttribute("productDTO",productDTO);
            return "productsAdd";
        }
        else {
            return "404";
        }
    }





}
