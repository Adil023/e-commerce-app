package com.adilgadirov.customer.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest request){
        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("exsist/{customer-id}")
    public ResponseEntity<Boolean> customerExists(@PathVariable("customer-id") String customerId) {
        return ResponseEntity.ok(customerService.exsistById(customerId));
    }

    @GetMapping("{customer-id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("customer-id") String customerId) {

        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @DeleteMapping("{customer-id}")
    public void deleteCustomerById(@PathVariable("customer-id") String customerId) {

         customerService.deleteCustomerById(customerId);;
    }

}
