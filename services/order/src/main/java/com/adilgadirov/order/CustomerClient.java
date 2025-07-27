package com.adilgadirov.order;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "customer-service", url = "${customer.service.url}")
public interface CustomerClient {

    Optional<CustomerResponse> findCustomerById(@PathVariable("customer-id")  String customerId);

}
