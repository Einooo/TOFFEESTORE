import java.util.Scanner;

public class sysControler {
    Catalog cat = new Catalog();
    Carts cart = new Carts(cat);
    Orders order = new Orders();
    customer cust = new customer("name", "email", "password", "phone", "address", Role.CUSTOMER);


    public void displayMenu() {
        System.out.println("Welcome to TOFFEE Store!");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Skip");
        System.out.println("4. Exit");
    }

    public void displayMenu2() {
        System.out.println("1. View Catalog");
        System.out.println("2. View Cart");
        System.out.println("3. Search");
        System.out.println("4. Logout");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();


        switch (choice) {
            case 1:
                cat.displayItems();
                System.out.println("To Add Item To Cart, enter 1.");
                System.out.println("To Return, enter 2.");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {
                    System.out.print("Enter the item name: ");
                    String name = scanner.next();
                    System.out.print("Enter the quantity: ");
                    int quantity = scanner.nextInt();
                    cart.addToCart(name, quantity);
                    System.out.println("Item added to cart.");
                    displayMenu2();
                } else if (choice2 == 2) {
                    displayMenu2();
                } else {
                    System.out.println("Invalid choice.");
                    displayMenu2();
                }
            case 2:
                cart.displayCart();
                System.out.println("To Remove Item From Cart, enter 1.");
                System.out.println("To Clear Cart, enter 2.");
                System.out.println("To Return, enter 3.");
                System.out.println("To place order, enter 4.");

                int choice3 = scanner.nextInt();
                if (choice3 == 1) {
                    System.out.print("Enter the item name: ");
                    String name = scanner.next();
                    cart.removeFromCart(name);
                    System.out.println("Item removed from cart.");
                    displayMenu2();
                } else if (choice3 == 2) {
                    cart.clearCart();
                    System.out.println("Cart cleared.");
                    displayMenu2();
                } else if (choice3 == 3) {
                    displayMenu2();
                }
                else if(choice3 ==4){
                    order.setCustomerName(cust.getName());
                    System.out.print("Enter your address: ");
                    String address = scanner.next();
                    order.setOrderAddress(address);
                    order.display_bill();
                    displayMenu2();
                }
                else {
                    System.out.println("Invalid choice.");
                    displayMenu2();
                }

            case 3:
                System.out.print("Enter the item name: ");
                String name = scanner.next();

                if (cat.search(name)){
                    System.out.println("To Add Item To Cart, enter 1.");
                    System.out.println("To Return, enter 2.");
                    int choice4 = scanner.nextInt();
                    if (choice4 == 1) {
                        System.out.print("Enter the quantity: ");
                        int quantity = scanner.nextInt();
                        cart.addToCart(name, quantity);
                        System.out.println("Item added to cart.");
                        displayMenu2();
                    } else if (choice4 == 2) {
                        displayMenu2();
                    } else {
                        System.out.println("Invalid choice.");
                        displayMenu2();
                    }
                } else {
                    System.out.println("Item not found.");
                    System.out.println("To Return, enter 2.");
                    int choice5 = scanner.nextInt();
                    if (choice5 == 2) {
                        displayMenu2();
                    } else {
                        System.out.println("Invalid choice.");
                        displayMenu2();
                    }
                }
                break;
            case 4:
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice.");
                displayMenu2();

        }
    }

    public void nonCustomerMenu() {
        System.out.println("1. View Catalog");
        System.out.println("2. Search");
        System.out.println("3. Return");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

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
        displayMenu();
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        Authencation auth = new Authencation();
        switch (choice) {
            case 1:
                if (auth.Register()) {
                    System.out.println("Registration successful.");
                    System.out.println("Login to continue.");
                    auth.Login(cust);
                    displayMenu2();
                } else {
                    System.out.println("Registration failed.");
                    mainMenu();
                }
                break;
            case 2:
                if (auth.Login(cust)) {
                    displayMenu2();
                } else {
                    System.out.println("Login failed.");
                    mainMenu();
                }
                break;
            case 3:
                nonCustomerMenu();
                break;
            case 4:
                System.out.println("Thank you for visiting TOFFEE Store!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");

        }
    }
}
