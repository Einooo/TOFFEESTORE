import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.FileWriter;
import java.io.IOException;

public class customer extends user{


    public customer(String name, String email, String password, String phone, String address) {
        super(name, email, password, phone, address);
    }

    @Override
    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();


        boolean isValid = customer.isValid(email, password);

        if (isValid) {
            try {
                FileWriter csvWriter = new FileWriter("customers.csv", true);
                csvWriter.append(name);
                csvWriter.append(",");
                csvWriter.append(email);
                csvWriter.append(",");
                csvWriter.append(password);
                csvWriter.append(",");
                csvWriter.append(phone);
                csvWriter.append(",");
                csvWriter.append(address);
                csvWriter.append("\n");
                csvWriter.flush();
                csvWriter.close();

                System.out.println("Registration successful!");
            } catch (IOException e) {
                System.out.println("Error writing to CSV file.");
            }
        } else {
            System.out.println("Invalid customer details.");
        }


    }


    public boolean login(String email, String password) {
        return false;
    }
}
