package com.adilgadirov.customer.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    String id;
    String firstName;
    String lastName;
    String email;
    Address address;


}
