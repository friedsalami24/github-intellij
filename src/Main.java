import com.ecommerce.*;
import java.util.List;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //Test Customer (constructor overloading)
        Customer c1 = new Customer("JohnDoe","john@example.com");
        Customer c2 = new Customer("JaneSmith");
        Order o1;

        //Test Administrator (final class)
        Administrator a1 = new Administrator("AdminUser","admin@ecom.com");
        a1.setDepartment("Logistics");

        //Test Product (Static counter)
        Product p1 = new Product("Laptop", 1200.00, "SKU1001");
        Product p2 = new Product("Mouse", 24.50, "SKU1002");
        Product p3 = new Product("Keyboard", 100.00, "SKU1003");
        Product p4 = new Product("Headset", 150.00, "SKU1004");
        //System.out.println("Total products cataloged: " + Product.getTotalProducts());

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
                
            }
        }


        //Test Order(initializer blocks, interface)
        Order o1 = new Order(c1, List.of(p1,p2), "2025-10-25");
        o1.displayOrder();
        System.out.println("Order total with 5% tax: $" + o1.calculateTotal(0.05));
        Order o2 = new Order(c2, List.of(p3,p4), "2027-10-09");
        o2.displayOrder();
        System.out.println("Order total with 5% tax: $" + o2.calculateTotal(0.05));

        //Test Nested Class
        ECommerce.Inventory mainWarehouse = new ECommerce.Inventory("Main Warehouse");
        mainWarehouse.checkStock(p1);
    }
}