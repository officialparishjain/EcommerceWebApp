package com.parishjain.EcommerceWebApp.dto;

import com.parishjain.EcommerceWebApp.models.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private Double weight;
    private String description;
    private String imageName;
    private Integer categoryId;

}
