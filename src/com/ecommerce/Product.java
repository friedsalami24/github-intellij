package com.ecommerce;

import java.util.Map;
import java.util.LinkedHashMap;

public class Product {
    private String name;
    private double price;
    private final String sku;
    private static int totalProducts = 0;

    //HASHMAP DECLARATION TO DISPLAY PRODUCTS CATALOG
    public static final Map<String, Double> DISPLAY_MAP = new LinkedHashMap<>();

    //HASHMAP TO LOOK UP FOR SELECTED PRODUCTS
    public static final Map<String, Double> OBJECT_MAP = new LinkedHashMap<>();

    //3 ARGUMENT CONSTRUCTOR (INCREMENT TOTAL PRODUCTS FOR EVERY OBJECT OF PRODUCT CLASS INITIALIZATION
    public Product(String name, double price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        totalProducts++;
    }

    //RECEIVE DATA(OBJECTS) FROM MAIN AND STORE INSIDE HASHMAP PARAMETER (NAME(KEY), PRICE(VALUE))
    public static void addToCatalog(Product product) {
        DISPLAY_MAP.put(product.getName(), product.getPrice());
    }

    //METHOD TO DISPLAY PRODUCTS CATALOG USING FOR EACH LOOP LAMBDA EXPRESSION
    public static void displayCatalog() {
        System.out.println("\n--- Available Products (Select by Name) ---");
        DISPLAY_MAP.forEach((name, price) ->
                System.out.printf("  > %-10s : $%.2f\n", name, price)
        );
        System.out.println("-------------------------------------------");
    }

    //FOR SELECTION LOOK UP (KEY) //RETURNS MATCHED KEY
    public static boolean isProductAvailable(String selection) {
        return DISPLAY_MAP.containsKey(selection);
    }

    /**
     * Retrieves the full Product object based on the product name.
     * NOTE: Assumes the name has already been validated using isProductAvailable().
     * @param selection The product name (key).
     * @return The complete Product object associated with the name.
     */
    public static Product getProductByName(String selection) {
        // We use the Map's built-in get method to retrieve the Product object.
        return OBJECT_MAP.get(selection);
    }

    //Getters RETURNS NAME
    public String getName() {
        return name;
    }

    //RETURNS PRICE
    public double getPrice() {
        return price;
    }

    //RETURNS SKU
    public String getSku() {
        return sku;
    }

    //RETURNS TOTAL PRODUCT
    public static int getTotalProducts() {
        return totalProducts;
    }
}