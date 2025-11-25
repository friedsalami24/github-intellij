package com.ecommerce;

import java.util.Map;
import java.util.LinkedHashMap;

public class Product {
    private String name;
    private double price;
    private final String sku;
    private static int totalProducts = 0;

    //TEST
    public static final Map<String, Double> PRODUCTS = new LinkedHashMap<>();

    public Product(String name, double price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        totalProducts++;
    }

    //TEST
    public static void addToCatalog(Product product) {
        PRODUCTS.put(product.getName(), product.getPrice());
    }

    public static void displayCatalog() {
        System.out.println("\n--- Available Products (Select by Name) ---");
        PRODUCTS.forEach((name, price) ->
                System.out.printf("  > %-10s : $%.2f\n", name, price)
        );
        System.out.println("-------------------------------------------");
    }

    //Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSku() {
        return sku;
    }

    public static int getTotalProducts() {
        return totalProducts;
    }
}