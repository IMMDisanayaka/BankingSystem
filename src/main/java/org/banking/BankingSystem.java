package org.banking;

import org.banking.service.InterestService;
import org.banking.service.TransactionService;

import java.util.Scanner;

public class BankingSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TransactionService transactionService = new TransactionService();
    private static final InterestService interestService = new InterestService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to AwesomeGIC Bank! What would you like to do?");
            System.out.println("[T/t] Input transactions");
            System.out.println("[I/i] Define interest rules");
            System.out.println("[P/p] Print statement");
            System.out.println("[Q/q] Quit");
            System.out.print("> ");

            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "T":
                case "t":
                    transactionService.handleTransactionInput();
                    break;
                case "I":
                case "i":
                    interestService.handleInterestRuleInput();
                    break;
                case "P":
                case "p":
                    transactionService.handlePrintStatement();
                    break;
                case "Q":
                case "q":
                    System.out.println("Thank you for banking with AwesomeGIC Bank. Have a nice day!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
