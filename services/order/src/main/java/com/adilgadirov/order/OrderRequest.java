package com.adilgadirov.order;

import com.adilgadirov.order.order.PaymentMethod;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "Amount must be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method cannot be null")
        PaymentMethod paymentMethod,
        @NotNull(message = "Customer ID cannot be null")
        String customerId,
        @NotEmpty(message = "You should provide at least one product")
        List<PurchaseRequest> products
) {
}
