package com.adilgadirov.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CustomerRequest{

    String id;
    @NotNull(message = "firstName name cannot be null")
    String firstName;
    @NotNull(message = "lastName name cannot be null")
    String lastName;
    @NotNull(message = "email name cannot be null")
    @Email(message = "email must be valid")
    String email;
    Address address;
}
