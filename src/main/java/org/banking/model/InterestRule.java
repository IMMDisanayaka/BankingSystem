package org.banking.model;

public class InterestRule {
    private final String date;
    private final String ruleId;
    private final double rate;

    public InterestRule(String date, String ruleId, double rate) {
        this.date = date;
        this.ruleId = ruleId;
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public String getRuleId() {
        return ruleId;
    }

    public double getRate() {
        return rate;
    }
}
