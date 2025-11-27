package com.ecommerce;
import java.util.List;

public class Order implements Payable {
    private int orderId;
    private Customer customer;
    private List<Product> productList;
    private String orderDate;
    private static int idCounter = 0;

    //Static initializer block
    static {
        System.out.println("Order processing system starting up.");
    }

    //instance initializer block
    {
        /*
        same as 2 lines of code
        idCounter = idCounter + 1;
        orderId = idCounter;
        */
        orderId = ++idCounter;
        //to show this block runs before constructor
        System.out.println("New Order ID generated: " + orderId);
    }

    public Order(Customer customer, List<Product> productList, String orderDate) {
        this.customer = customer;
        this.productList = productList;
        this.orderDate = orderDate;
    }

    //providing body for calculateTotal() from interface Payable
    @Override
    public double calculateTotal(double taxRate) {
        double subtotal = 0.0;
            for (Product P : productList) {
                subtotal = subtotal + P.getPrice();
            }

            //returns subtotal
            return subtotal * (1 + taxRate);
    }

    //display method
    public void displayOrder() {
        /*System.out.println("> %-10Order ID: " + orderId);
        System.out.println("> %-10Customer: " + customer.getUsername());
        System.out.println("> %-10Date: " + orderDate);*/

        System.out.println(String.format(" > %-12s %s", "Order ID               : ", orderId));
        System.out.println(String.format(" > %-12s %s", "Customer ID            : ", customer.getUsername()));
        System.out.println(String.format(" > %-12s %s", "Date                   : ", orderDate));
        System.out.println(String.format(" > %-12s %s", "Total products ordered : ", Product.getTotalProductsOrdered()));
    }
}