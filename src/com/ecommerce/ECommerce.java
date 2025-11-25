package com.ecommerce;

public class ECommerce {
    //static nested class (ECommerce.Inventory)
    public static class Inventory {
        private String location;

        //cons
        public Inventory(String location){
            this.location = location;
        }

        //methods
        public void checkStock(Product P){
            System.out.println("Stock for " + P.getName() + " checked at " + location);
        }
    }


}