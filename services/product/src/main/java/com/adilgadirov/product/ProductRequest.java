package com.adilgadirov.product;

import com.adilgadirov.product.catagory.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class ProductRequest {
     Integer id;
     String name;
     String description;
     BigDecimal price;
     double  availableQuantity;
}
