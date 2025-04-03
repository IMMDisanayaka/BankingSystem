package org.banking.model;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountId;
    private double balance;
    private final List<Transaction> transactions;

    public BankAccount(String accountId) {
        this.accountId = accountId;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public boolean addTransaction(String date, String type, double amount) {
        if (type.equals("W") && (balance < amount || transactions.isEmpty())) {
            return false;
        }

        String txnId = String.format("%s-%02d", date, transactions.size() + 1);
        transactions.add(new Transaction(date, txnId, type, amount));

        balance += type.equals("D") ? amount : -amount;
        return true;
    }

    public void printStatement() {
        System.out.println("Account: " + accountId);
        System.out.println("| Date     | Txn Id      | Type | Amount |");
        for (Transaction txn : transactions) {
            System.out.printf("| %s | %s | %s    | %.2f |%n", txn.getDate(), txn.getTxnId(), txn.getType(), txn.getAmount());
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }
}
