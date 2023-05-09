import java.util.Scanner;


public class Main {

    public void displayMenu() {
        System.out.println("Welcome to TOFFEE Store!");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Skip");
        System.out.println("4. Exit");
    }

    public void displayMenu2() {
        System.out.println("\n");
        System.out.println("1. View Catalog");
        System.out.println("2. View Cart");
        System.out.println("3. Search");
    }

    public void nonCustomerMenu() {
        System.out.println("1. View Catalog");
        System.out.println("2. Search");
        System.out.println("3. Return");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        Catalog cat = new Catalog();
        switch (choice) {
            case 1:
                cat.displayItems();
                System.out.println("To Return, enter 3.");
                int choice2 = scanner.nextInt();
                if (choice2 == 3) {
                    nonCustomerMenu();
                } else {
                    System.out.println("Invalid choice.");
                    nonCustomerMenu();
                }
                break;
            case 2:
                System.out.print("Enter the item name: ");
                String name = scanner.next();
                if (cat.search(name)){
                    System.out.println("To Return, enter 3.");
                    int choice3 = scanner.nextInt();
                    if (choice3 == 3) {
                        nonCustomerMenu();
                    }
                    else {
                        System.out.println("Invalid choice.");
                        nonCustomerMenu();
                    }
                } else {
                    System.out.println("Item not found.");
                    System.out.println("To Return, enter 3.");
                    int choice4 = scanner.nextInt();
                    if (choice4 == 3) {
                        nonCustomerMenu();
                    } else {
                        System.out.println("Invalid choice.");
                        nonCustomerMenu();
                    }
                };
                break;
            case 3:
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice.");
                nonCustomerMenu();
        }

    }

    public void mainMenu(){
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
                main.nonCustomerMenu();
                break;
            case 4:
                System.out.println("Thank you for visiting TOFFEE Store!");
                break;
            default:
                System.out.println("Invalid choice.");

        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.mainMenu();
    }
}