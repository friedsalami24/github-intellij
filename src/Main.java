import com.ecommerce.*;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    //TO SHOWCASE EVERY FUNCTION AND DATA FLOW COMPLETELY, ADMINFLOW AND CUSTOMERFLOW CLASS WILL BE CREATED AS A CONDITIONAL
    //CHOICE BASED ON WHAT USER WILL CHOOSE

    //CREATING CONDITIONAL CHOICE FOR USER TO SELECT (CUSTOMER OR ADMIN)
    private static void appFlow (Scanner scanner) {
        System.out.println("\n=== OOP PROJECT ECOMMERCE SYSTEM ===");
        System.out.println("Please choose : (1) Customer      (2) Administrator");
        System.out.println("Enter your choice (eg; 1 or 2) : ");

        String choice = scanner.nextLine().trim();

        if(choice.equals(1)) {
            //CALLING CUSTOMER FLOW
            //Customer customer = customerFlow(scanner);

            System.out.println("\n=== CUSTOMER FLOW STARTING ===");
        } else if (choice.equals(2)) {
            //CALLING ADMIN FLOW
            Administrator admin = adminFlow(scanner);

            System.out.println("\n=== ADMINISTRATOR FLOW STARTING ===");
        }

    }



    //CREATING ADMIN FLOW CLASS
    private static Administrator adminFlow(Scanner scanner) {
        System.out.println("\n=== Admin Login ===");

        System.out.println("Enter Admin Username : ");
        String adminUsername = scanner.nextLine();

        System.out.println("Enter Email :  ");
        String adminEmail = scanner.nextLine();

        //INITIALIZING ADMIN OBJECT OF CLASS ADMINISTRATOR TO PASS USERNAME AND EMAIL
        Administrator admin1 = new Administrator(adminUsername, adminEmail);

        //UTILIZING SETTER IN ADMINISTRATOR CLASS BY ASKING ADMIN WHAT DEPARTMENT THEY BELONG TO
        System.out.println("Enter Department (eg; Logistic, IT, Sales): ");
        String adminDepartment = scanner.nextLine().trim(); //using trim to cutout any spacebar entered after department
        admin1.setDepartment(adminDepartment); //adding department to existing admin object

        admin1.displayProfile();
    }

    private static Customer custFlow(Scanner scanner) {
        System.out.println("\n=== CUSTOMER LOGIN ===");

        System.out.println("Enter Username : ");
        String custName = scanner.nextLine().trim();

        System.out.println("Enter email : ");
        String custEmail = scanner.nextLine().trim();

        Customer c1 = new Customer(custName, custEmail);
    }

    private static void productInitialization(Scanner scanner) {
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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


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

        System.out.println("Total products cataloged: " + Product.getTotalProducts());

        //USER SELECTION LOGIC
        System.out.println("\n--- Starting New Order ---");
        Product.displayCatalog();

        List<Product> selectedProducts = new ArrayList<>();
        String productSelection;
        boolean orderProcess = true;

        while(orderProcess) {
            System.out.println("Enter product name to add (or type 'done'");
            productSelection = scanner.nextLine().trim();

            if (productSelection.equalsIgnoreCase("done")) {
                orderProcess = false; //exit loop, end program
            }
            else if (Product.isProductAvailable(productSelection)) {
                Product chosenProduct = Product.getProductByName(productSelection);
                selectedProducts.add(chosenProduct);
                System.out.println(productSelection + " has been added to cart.");
            }
            else {
                System.out.println("Product typed not found, please try again.");
            }
        }

        /*if (!selectedProducts.isEmpty()) {
            // Replace the hardcoded list with the dynamic list:
            Order o1 = new Order(c1, selectedProducts, "2025-10-25");

            o1.displayOrder();
            System.out.println("Order total with 5% tax: $" + o1.calculateTotal(0.05));
        } else {
            System.out.println("Order cancelled. No items selected.");
        }*/


        //Test Order(initializer blocks, interface)
        /*Order o1 = new Order(c1, List.of(p1,p2), "2025-10-25");
        o1.displayOrder();
        System.out.println("Order total with 5% tax: $" + o1.calculateTotal(0.05));*/
        Order o2 = new Order(c2, List.of(p3,p4), "2027-10-09");
        o2.displayOrder();
        System.out.println("Order total with 5% tax: $" + o2.calculateTotal(0.05));

        //Test Nested Class
        ECommerce.Inventory mainWarehouse = new ECommerce.Inventory("Main Warehouse");
        mainWarehouse.checkStock(p1);
    }
}