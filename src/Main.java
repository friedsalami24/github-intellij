import com.ecommerce.*;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    //TO SHOWCASE EVERY FUNCTION AND DATA FLOW COMPLETELY, ADMINFLOW AND CUSTOMERFLOW CLASS WILL BE CREATED AS A CONDITIONAL
    //CHOICE BASED ON WHAT USER WILL CHOOSE

    //CREATING CONDITIONAL CHOICE FOR USER TO SELECT (CUSTOMER OR ADMIN)
    private static void userFlowProcess(Scanner scanner) {
        System.out.println("\n=== OOP PROJECT ECOMMERCE SYSTEM ===");
        System.out.println("Please choose : (1) Customer      (2) Administrator");
        System.out.println("Enter your choice (eg; 1 or 2) : ");

        //using string as a data type for choice input
        String choice = scanner.nextLine();

        //adding conditional statement for user choice
        //1 = is for customer flow process
        //main will call customerFlowProcess if choice is 1
        if (choice.equals("1")) {
            //CALLING CUSTOMER FLOW
            System.out.println("\n=== CUSTOMER FLOW STARTING ===");


            Customer customer = customerFlowProcess(scanner);

            //adding a simple indicator to indicate the flow process is finished
            System.out.println("\n=== CUSTOMER FLOW FINISHED ===");

        } else if (choice.equals("2")) {
            //CALLING ADMIN FLOW
            System.out.println("\n=== CUSTOMER FLOW STARTING ===");
            Administrator admin = administratorFlowProcess(scanner);

            System.out.println("\n=== ADMINISTRATOR FLOW ADMIN FLOW FINISHED ===");
        }

    }

    //CREATING ADMIN FLOW CLASS
    private static Administrator administratorFlowProcess(Scanner scanner) {
        System.out.println("\n=== Admin Login ===");

        System.out.println("Enter Admin Username : ");
        String adminUsername = scanner.nextLine();

        System.out.println("Enter Email :  ");
        String adminEmail = scanner.nextLine();

        System.out.println("\n=== ADMIN LOG IN SUCCESSFUL");

        //INITIALIZING ADMIN OBJECT OF CLASS ADMINISTRATOR TO PASS USERNAME AND EMAIL
        Administrator admin1 = new Administrator(adminUsername, adminEmail);

        //UTILIZING SETTER IN ADMINISTRATOR CLASS BY ASKING ADMIN WHAT DEPARTMENT THEY BELONG TO
        System.out.println("Enter Department (eg; Logistic, IT, Sales): ");
        String adminDepartment = scanner.nextLine().trim(); //using trim to cutout any spacebar entered after department
        admin1.setDepartment(adminDepartment); //adding department to existing admin object

        admin1.displayProfile();

        return admin1;
    }

    //CREATING CUSTOMER FLOW CLASS
    private static Customer customerFlowProcess(Scanner scanner) {
        System.out.println("\n=== CUSTOMER LOGIN ===");

        //PHASE 1 (CUSTOMER USERNAME AND EMAIL PROMPT)
        System.out.println("Enter Username : ");
        String customerUserName = scanner.nextLine().trim();

        System.out.println("Enter email : ");
        String customerEmail = scanner.nextLine().trim();

        Customer customerObject = new Customer(customerUserName, customerEmail);

        System.out.println("\n=== CUSTOMER LOG IN SUCCESSFUL ===");

        //PHASE 2 (TAKING CUSTOMERS ORDER)
        System.out.println("\n=== STARTING ORDER ===");

        Product.displayProductCatalog();

        List<Product> selectedProducts = new ArrayList<>();
        String productSelection;
        boolean orderProcess = true;
        String purchaseDate = "";

        while (orderProcess) {
            System.out.println("Enter product name to add (or type 'done'");
            productSelection = scanner.nextLine().trim();

            if (productSelection.equalsIgnoreCase("done")) {
                System.out.println("Enter date (eg; 2025-10-29) : ");
                purchaseDate = scanner.nextLine().trim();
                orderProcess = false; //exit loop, end program
            } else if (Product.isProductAvailable(productSelection)) {
                //retrieve the product object
                Product chosenProduct = Product.getProductByName(productSelection);

                if (chosenProduct != null) {
                    //adding products to array list
                    selectedProducts.add(chosenProduct);
                    System.out.println(productSelection + " has been added to cart.");
                } else {
                    System.out.println("Internal error retrieving product data. Please try again.");
                }
            }
        }
            //PHASE 3
            if (!selectedProducts.isEmpty()) {
                Order orderObject = new Order(customerObject, selectedProducts, purchaseDate);
                orderObject.displayOrder();
                System.out.println("Order total with 5% tax: $" + orderObject.calculateTotal(0.05));
                System.out.println();
                ECommerce.Inventory mainWarehouse = new ECommerce.Inventory("Main Warehouse");
                mainWarehouse.checkStock(p1);

                System.out.println("\nThank you for your order! Session complete.");
            } else {
                System.out.println("No order selected, order cancelled. Bye");
            }

            return customerObject;
        }

        //CREATING PRODUCT INITIALIZATION TO CREATE AND STORE PRODUCTS IN MAP FOR DISPLAY
        private static void productInitialization () {
            //Test Product (Static counter)
            Product p1 = new Product("Laptop", 1200.00, "SKU1001");
            Product p2 = new Product("Mouse", 24.50, "SKU1002");
            Product p3 = new Product("Keyboard", 100.00, "SKU1003");
            Product p4 = new Product("Headset", 150.00, "SKU1004");
            //System.out.println("Total products cataloged: " + Product.getTotalProducts());


            //THIS BLOCK IS TO ADD CREATED PRODUCTS OBJECT TO DISPLAYMAP FOR CATALOG DISPLAY
            Product.addToCatalog(p1);
            Product.addToCatalog(p2);
            Product.addToCatalog(p3);
            Product.addToCatalog(p4);

            System.out.println("Total products in catalog: " + Product.getTotalProducts());
        }

        public static void main (String[]args){
            Scanner scanner = new Scanner(System.in);

            //ADDING PRODUCTS TO CATALOG
            productInitialization();

            //STARTING PROCESS
            userFlowProcess(scanner);

            //CLOSING SCANNER
            scanner.close();

            //Test Order(initializer blocks, interface)
        /*Order o1 = new Order(c1, List.of(p1,p2), "2025-10-25");
        o1.displayOrder();
        System.out.println("Order total with 5% tax: $" + o1.calculateTotal(0.05));
        Order o2 = new Order(c2, List.of(p3,p4), "2027-10-09");
        o2.displayOrder();
        System.out.println("Order total with 5% tax: $" + o2.calculateTotal(0.05));*/

            //Test Nested Class
        /*ECommerce.Inventory mainWarehouse = new ECommerce.Inventory("Main Warehouse");
        mainWarehouse.checkStock(p1);*/
        }
    }

