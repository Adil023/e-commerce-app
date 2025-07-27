package com.adilgadirov.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;

    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BuisnessException("Customer not found"));
    }
}
