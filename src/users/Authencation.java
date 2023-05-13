package users;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authencation {

    public String otp = generatOtp();
    public static boolean isValidMail(String email) {

        String emailRegex = "^[A-Za-z0-9]+@[A-Za-z0-9.-]+.com$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        if (!emailMatcher.matches()) {
            System.out.print("Invalid email \nEnter Valid One: ");
            return false;
        }
        return true;
    }

    public static boolean isValidPass(String password) {

        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.]).{8,20}";

        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        if (!passwordMatcher.matches()) {
            System.out.println("Invalid password \nEnter Valid One: ");
            return false;
        }
        return true;
    }
    public Boolean Login(customer p) {
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
                    System.out.println("Welcome " + data[0] + "!");
                    p.setName(data[0]);
                    p.setEmail(data[1]);
                    p.setPassword(data[2]);
                    p.setPhone(data[3]);
                    p.setAddress(data[4]);
                    return true;
                }
            }
            System.out.println("User not found.");
            p= null;
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
        while (!isValidMail(userEmail)) {
            userEmail = Scanner.nextLine();
        }
        sendOtp(userEmail);
        System.out.print("Enter your OTP: ");
        String userOtp = Scanner.nextLine();
        while (!userOtp.equals(otp)) {
            System.out.println("Invalid OTP");
            System.out.print("Enter your OTP: ");
            userOtp = Scanner.nextLine();
        }
        System.out.print("Enter your password: ");
        String userPassword = Scanner.nextLine();
        while (!isValidPass(userPassword)) {
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
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendOtp(String email) {
        try {
            // Command to run the Python script
            String command = "python";
            // Path to the Python script
            //                              ***** use ur own path *****
            String scriptPath = "D:\\Java projects\\TOFFEESTORE\\src\\otpscript.py";

            // Recipient's email
            String senderEmail = "muhannadeion1@gmail.com";
            String sender_password = "cuzkvtsghkoehnid";


            // Create the process builder
            ProcessBuilder processBuilder = new ProcessBuilder(command, scriptPath, senderEmail, sender_password, email, otp);
            // Start the process
            Process process = processBuilder.start();

            // Wait for the process to complete
            int exitCode = process.waitFor();
            //System.out.println("Python script executed with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String generatOtp(){
        int otp = (int)(Math.random()*9000)+1000;
        return Integer.toString(otp);
    }
}



