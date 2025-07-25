package com.adilgadirov.product;

public record ProductPurchaseRequest(
        Integer productId,
        double quantity
) {
}
