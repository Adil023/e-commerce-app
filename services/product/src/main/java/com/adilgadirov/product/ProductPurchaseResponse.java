package com.adilgadirov.product;


import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductPurchaseResponse(

        Integer productId,
        String name,
        String description,
        double quantity,
        BigDecimal price
) {
}
