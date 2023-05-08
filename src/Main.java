import java.util.Scanner;


public class Main {

    public void displayMenu() {
        System.out.println("Welcome to TOFFEE Store!");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Skip");
    }

    public void displayMenu2() {
        System.out.println("\n");
        System.out.println("1. View Catalog");
        System.out.println("2. View Cart");
        System.out.println("3. Search");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Main main = new Main();
        main.displayMenu();

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        customer cust = new customer("name", "email", "password", "phone", "address");
        switch (choice) {
            case 1:
                cust.register();
                break;
            case 2:
                cust.login();
                Catalog cat = new Catalog();
                cat.displayItems();
                break;
            case 3:
                Catalog cat2 = new Catalog();
                cat2.displayItems();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}


