package com.adilgadirov.product;

import com.adilgadirov.product.catagory.Category;
import com.adilgadirov.product.product.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .availableQuantity(request.getAvailableQuantity())
                .price(request.getPrice())
                .category(Category.builder()
                        .id(request.getCategoryId())
                        .build())
                .build();
    }

    public ProductResponse productResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .build();
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product storedProduct, double quantity) {

        return new ProductPurchaseResponse(
                storedProduct.getId(),
                storedProduct.getName(),
                storedProduct.getDescription(),
                quantity,
                storedProduct.getPrice()
        );
    }
}