package com;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManager {

    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void createAccount() {

        System.out.print("Enter the customer name: ");
        String name = sc.nextLine().trim();

        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Enter again: ");
            name = sc.nextLine().trim();
        }

        System.out.print("Enter the account number: ");
        String accNo = sc.nextLine().trim();

        while (!accNo.matches("\\d+") || isAccountExists(accNo)) {
            System.out.print("Invalid or duplicate account number. Enter again: ");
            accNo = sc.nextLine().trim();
        }

        System.out.print("Enter the Initial Balance: ");
        double balance;

        try {
            balance = Double.parseDouble(sc.nextLine());
            if (balance < 0) throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid balance.To Setting balance to 0.");
            balance = 0;
        }

        accounts.add(new BankAccount(name, accNo, balance));
        System.out.println("Account is created successfully!✅✅✅");
    }

    private boolean isAccountExists(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                return true;
            }
        }
        return false;
    }

    private BankAccount findAccount(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo)) {
                return acc;
            }
        }
        return null;
    }

    public void deposit() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        BankAccount acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount;

        try {
            amount = Double.parseDouble(sc.nextLine());
            if (amount <= 0) throw new Exception();
            acc.deposit(amount);
            System.out.println("✅ Deposit successful. New Balance: ₹" + acc.getBalance());
        } catch (Exception e) {
            System.out.println("❌ Invalid amount!");
        }
    }

    public void withdraw() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        BankAccount acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount;

        try {
            amount = Double.parseDouble(sc.nextLine());
            if (amount <= 0) throw new Exception();

            if (acc.withdraw(amount)) {
                System.out.println("✅ Withdrawal successful. Remaining Balance: ₹" + acc.getBalance());
            } else {
                System.out.println("❌ Insufficient funds!");
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid amount!");
        }
    }

    public void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        BankAccount acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        System.out.println("Current Balance: ₹" + acc.getBalance());
    }

    public void viewAccountDetails() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        BankAccount acc = findAccount(accNo);
        if (acc == null) {
            System.out.println("❌ Account not found!");
            return;
        }

        acc.displayDetails();
    }
}

