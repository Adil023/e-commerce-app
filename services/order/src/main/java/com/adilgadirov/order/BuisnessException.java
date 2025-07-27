package com.adilgadirov.order;

public class BuisnessException extends RuntimeException {
    public BuisnessException(String customerNotFound) {
        super(customerNotFound);
    }
}
