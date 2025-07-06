package com.adilgadirov.customer.customer;

import com.adilgadirov.customer.customer.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(@Valid CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request)).getId();
        return customer;
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        customerRepository.findById(request.getId())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Customer with id %s not found", request.getId()
                ))
                );
    }

    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponse)
                .toList();
    }

    public Boolean exsistById(String customerId) {
        return customerRepository.findById(customerId)
                .isPresent();
    }

    public CustomerResponse getCustomerById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Customer with id %s not found", customerId)
                ));
    }

    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);

    };
}
