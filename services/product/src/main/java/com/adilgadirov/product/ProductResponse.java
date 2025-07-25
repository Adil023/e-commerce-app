package com.adilgadirov.product;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class ProductResponse {
        Integer id;

        String name;

        String description;

        double availableQuantity;

        BigDecimal price;

        Integer categoryId;

        String categoryName;
        String categoryDescription;
}
