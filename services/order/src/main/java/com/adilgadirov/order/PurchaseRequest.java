package com.adilgadirov.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Product ID cannot be null")
        Integer id,
        @Positive(message = "Quantity must be positive")
        double quantity
) {
}
