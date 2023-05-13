package users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;



public class customer extends user{

    private int loyaltyPoints = 0;//just a skeleton for now

    public customer(String name, String email, String password, String phone, String address, Role role ) {
        super(name, email, password, phone, address, Role.CUSTOMER);
    }



}