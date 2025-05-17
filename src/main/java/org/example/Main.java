package org.example;

import org.example.services.ConsoleLogger;
import org.example.services.Logger;
import org.example.services.UserCommunication;

import java.util.Scanner;

public class Main {
    static Logger logger = new ConsoleLogger();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        UserCommunication uc = new UserCommunication();
        uc.cart.add();
        uc.cart.getProductMap(true);
        uc.cart.add();
        uc.cart.buy();
        uc.getProductList(true);
    }

}