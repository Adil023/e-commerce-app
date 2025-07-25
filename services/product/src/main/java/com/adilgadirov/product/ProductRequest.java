package com.adilgadirov.product;

import com.adilgadirov.product.catagory.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductRequest {
     @NotNull(message = "Id is required")
     Integer id;
     @NotBlank(message = "Name is required")
     String name;
     @NotBlank(message = "Description is required")
     String description;
     @Positive(message = "Price must be positive")
     BigDecimal price;
     @Positive(message = "Available quantity must be positive")
     double  availableQuantity;
     @NotNull(message = "Category ID is required")
     Integer categoryId;
}
