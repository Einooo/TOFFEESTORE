import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Loyalty Program!");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        customer cust = new customer("name", "email", "password", "phone", "address");
        switch (choice) {
            case 1:
                cust.register();
                break;

            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}


