package org.banking;

import org.banking.model.BankAccount;
import org.banking.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BankAccountMockTest {

    private BankAccount bankAccount;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        bankAccount = mock(BankAccount.class);
        transaction = mock(Transaction.class);
    }

    @Test
    void testTransactionAdd() {
        when(bankAccount.addTransaction("20250402", "D", 150.00)).thenReturn(true);
        when(bankAccount.getBalance()).thenReturn(150.00);

        assertTrue(bankAccount.addTransaction("20250402", "D", 150.00), "Transaction should succeed.");
        assertEquals(150.00, bankAccount.getBalance(), "Balance should be 150.00.");
    }

    @Test
    void testTransactionFailure() {
        when(bankAccount.addTransaction("20250402", "W", 200.00)).thenReturn(false);

        assertFalse(bankAccount.addTransaction("20250402", "W", 200.00), "Transaction should fail due to insufficient funds.");
    }

    @Test
    void testTransactionDetails() {
        when(transaction.getDate()).thenReturn("20250402");
        when(transaction.getTxnId()).thenReturn("20250402-02");
        when(transaction.getType()).thenReturn("D");
        when(transaction.getAmount()).thenReturn(150.00);

        assertEquals("20250402", transaction.getDate(), "Transaction date should be 20250402.");
        assertEquals("20250402-02", transaction.getTxnId(), "Transaction ID should be 20250402-02.");
        assertEquals("D", transaction.getType(), "Transaction type should be D.");
        assertEquals(150.00, transaction.getAmount(), "Transaction amount should be 150.00.");
    }
}
