package com.adilgadirov.product;

import com.adilgadirov.product.exception.ProductNotFoundException;
import com.adilgadirov.product.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        var save = productRepository.save(product);
        return save.getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request.stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        var storedProducts = productRepository.findAllByIdInOrderById(productIds);

        if (productIds.size() != storedProducts.size()) {
            throw new ProductNotFoundException("No products found for the given IDs");
        }

        var storesRequest = request.stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .collect(Collectors.toList());

        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();

        for(int i=0;i< storedProducts.size(); i++) {
            var storedProduct = storedProducts.get(i);
            var purchaseRequest = storesRequest.get(i);

            if (storedProduct.getAvailableQuantity() < purchaseRequest.quantity()) {
                throw new ProductNotFoundException(format("Not enough quantity for product with id %s", purchaseRequest.productId()));
            }

            var newAvailableQuantity = storedProduct.getAvailableQuantity() - purchaseRequest.quantity();
            storedProduct.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(storedProduct);

            purchasedProducts.toProductPurchaseResponse(storedProduct, purchaseRequest.quantity());
        }


        return purchasedProducts;
    }

    public ProductResponse findById(Integer productId){
       return productRepository.findById(productId)
                .map(mapper::productResponse)
                .orElseThrow(() -> new ProductNotFoundException(format("Product with id %s not found", productId)));
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(mapper::productResponse)
                .toList();
    }
}
