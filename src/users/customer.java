package users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


/**
 * The type Customer.
 */
public class customer extends user{

    private int loyaltyPoints = 0;//just a skeleton for now

    /**
     * Instantiates a new Customer.
     *
     * @param name     the name
     * @param email    the email
     * @param password the password
     * @param phone    the phone
     * @param address  the address
     * @param role     the role
     */
    public customer(String name, String email, String password, String phone, String address, Role role ) {
        super(name, email, password, phone, address, Role.CUSTOMER);
    }



}