package org.banking.service;

import org.banking.model.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TransactionService {
    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, BankAccount> accounts = new HashMap<>();

    public void handleTransactionInput() {
        while (true) {
            System.out.println("Please enter transaction details in <Date> <Account> <Type> <Amount> format (or blank to return):");
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) return;

            String[] parts = input.split(" ");
            if (parts.length != 4) {
                System.out.println("Invalid format. Try again.");
                continue;
            }

            String date = parts[0];
            String accountId = parts[1];
            String type = parts[2].toUpperCase();
            double amount;

            try {
                amount = Double.parseDouble(parts[3]);
                if (amount <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Try again.");
                continue;
            }

            accounts.putIfAbsent(accountId, new BankAccount(accountId));
            BankAccount account = accounts.get(accountId);

            if (!account.addTransaction(date, type, amount)) {
                System.out.println("Transaction failed. Insufficient funds or invalid operation.");
            }
            account.printStatement();
        }
    }

    public void handlePrintStatement() {
        System.out.println("Please enter account to generate the statement (or blank to return):");
        System.out.print("> ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return;

        if (!accounts.containsKey(input)) {
            System.out.println("Account not found.");
            return;
        }

        accounts.get(input).printStatement();
    }
}
