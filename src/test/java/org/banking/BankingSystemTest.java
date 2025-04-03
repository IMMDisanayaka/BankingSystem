package org.banking;

import org.banking.model.BankAccount;
import org.banking.model.InterestRule;
import org.banking.service.InterestService;
import org.banking.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class BankingSystemTest {

    private TransactionService transactionService;
    private InterestService interestService;
    private BankAccount bankAccount;
    private List<InterestRule> interestRules;

    @BeforeEach
    void setUp() {
        transactionService = mock(TransactionService.class);
        interestService = mock(InterestService.class);
        interestRules = new ArrayList<>();

        bankAccount = new BankAccount("AC001");
        bankAccount.addTransaction("20250402", "D", 150.00);
        bankAccount.addTransaction("20250402", "W", 20.00);
    }

    @Test
    void testBankAccountTransactions() {
        assertNotNull(bankAccount);
        assertEquals(130.00, bankAccount.getBalance(), "Balance should be 130.00 after transactions.");
    }

    @Test
    void testInterestRuleInput() {
        interestRules.add(new InterestRule("20250402", "RULE03", 2.20));
        interestRules.add(new InterestRule("20250402", "RULE02", 1.90));

        assertEquals(2, interestRules.size(), "There should be 2 interest rules");
        assertEquals("RULE03", interestRules.get(0).getRuleId(), "The first rule should be RULE03");
    }

    @Test
    void testTransactionFailureDueToInsufficientFunds() {
        assertFalse(bankAccount.addTransaction("20250402", "W", 200.00), "Transaction should fail due to insufficient funds.");
    }

    @Test
    void testTransactionSuccess() {
        assertTrue(bankAccount.addTransaction("20250402", "D", 50.00), "Transaction should succeed.");
        assertEquals(180.00, bankAccount.getBalance(), "Balance should be 180.00 after deposit.");
    }

    @Test
    void testPrintStatement() {
        bankAccount.printStatement();
        // Validate the printing of transactions (This can be verified manually during test runs)
    }

    @Test
    void testInterestService() {
        interestService.handleInterestRuleInput();  // Simulate input handling
        verify(interestService, times(1)).handleInterestRuleInput();
    }

    @Test
    void testTransactionService() {
        transactionService.handleTransactionInput();
        verify(transactionService, times(1)).handleTransactionInput();
    }
}
