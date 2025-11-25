package com.ecommerce;

public interface Payable {
    //contract for class implementing payable must provide a body for calculateTotal
    double calculateTotal(double TaxRate);
}