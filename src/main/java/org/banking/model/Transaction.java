package org.banking.model;

public class Transaction {
    private final String date;
    private final String txnId;
    private final String type;
    private final double amount;

    public Transaction(String date, String txnId, String type, double amount) {
        this.date = date;
        this.txnId = txnId;
        this.type = type;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getTxnId() {
        return txnId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
