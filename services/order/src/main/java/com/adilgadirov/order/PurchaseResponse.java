package com.adilgadirov.order;

import java.math.BigDecimal;

public record PurchaseResponse(
    Integer productId,
    String name,
    String description,
    double quantity,
    BigDecimal price
) {
}
