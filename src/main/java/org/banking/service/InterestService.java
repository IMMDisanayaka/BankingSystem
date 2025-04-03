package org.banking.service;

import org.banking.model.InterestRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterestService {
    private static final Scanner scanner = new Scanner(System.in);
    private final List<InterestRule> interestRules = new ArrayList<>();

    public void handleInterestRuleInput() {
        while (true) {
            System.out.println("Please enter interest rule details in <Date> <RuleId> <Rate in %> format (or blank to return):");
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) return;

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid format. Try again.");
                continue;
            }

            String date = parts[0];
            String ruleId = parts[1];
            double rate;

            try {
                rate = Double.parseDouble(parts[2]);
                if (rate <= 0 || rate >= 100) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Invalid interest rate. Try again.");
                continue;
            }

            interestRules.removeIf(rule -> rule.getDate().equals(date));
            interestRules.add(new InterestRule(date, ruleId, rate));

            System.out.println("Interest rules:");
            for (InterestRule rule : interestRules) {
                System.out.printf("| %s | %s | %.2f%% |%n", rule.getDate(), rule.getRuleId(), rule.getRate());
            }
        }
    }
}
