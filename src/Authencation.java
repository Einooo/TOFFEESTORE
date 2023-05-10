import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authencation {// here login an register for users

    public static boolean isValid(String email, String password) {

        String emailRegex = "^[A-Za-z0-9]+@[A-Za-z0-9.-]+$";
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.]).{8,20}";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);

        if (!emailMatcher.matches()) {
            System.out.print("Invalid email \nEnter Valid One: ");
            return false;
        } else if (!passwordMatcher.matches()) {
            System.out.println("Invalid password \nEnter Valid One: ");
            return false;
        }
        return true;
    }


    public Boolean Login() {
        System.out.println("Login Form");
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Enter your email address: ");
        String userEmail = Scanner.nextLine();
        System.out.print("Enter your password: ");
        String userPassword = Scanner.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("customers.csv"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equals(userEmail) && data[2].equals(userPassword)) {
                    System.out.println("Login successful!");
                    return true;
                }
            }
            System.out.println("User not found.");
            return false;
        } catch (IOException e) {
            System.out.println("Error reading from CSV file.");
        }
        return true;
    }
    public Boolean Register() {
        System.out.println("Registration Form");
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String userName = Scanner.nextLine();
        System.out.print("Enter your email address: ");
        String userEmail = Scanner.nextLine();
        while (!isValid(userEmail, userEmail)) {
            userEmail = Scanner.nextLine();
        }
        System.out.print("Enter your password: ");
        String userPassword = Scanner.nextLine();
        while (!isValid(userPassword, userPassword)) {
            userPassword = Scanner.nextLine();
        }
        System.out.print("Enter your phone number: ");
        String userPhone = Scanner.nextLine();
        System.out.print("Enter your address: ");
        String userAddress = Scanner.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("customers.csv"));
            String line = null;
            boolean isRegistered = false;
            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                // Check if the user is already registered
                if (fields[1].equals(userEmail)) {
                    isRegistered = true;
                    break;
                }
            }
            reader.close();
            if (isRegistered) {
                System.out.println("User already registered");
                return false;
            } else {
                // Open the customers.csv file for appending new data
                BufferedWriter writer = new BufferedWriter(new FileWriter("customers.csv", true));
                // Write the new user data to the file
                writer.write( userName + "," + userEmail + "," + userPassword + "," + userPassword + "," + userAddress + "\n");
                customer customer = new customer(userName, userEmail, userPassword, userPhone, userAddress, Role.CUSTOMER);
                writer.close();
                System.out.println("User registered successfully");
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}



