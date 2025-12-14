package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BankManager manager = new BankManager();
        Scanner sc = new Scanner(System.in);
        // TODO Auto-generated method stub
        while (true) {
            System.out.println("\n==============================");
            System.out.println("   BANK ACCOUNT MANAGEMENT");
            System.out.println("==============================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid!");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.createAccount();
                    break;
                case 2:
                    manager.deposit();
                    break;
                case 3:
                    manager.withdraw();
                    break;
                case 4:
                    manager.checkBalance();
                    break;
                case 5:
                    manager.viewAccountDetails();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid!");
            }
        }
    }
}


