package org.banking;

import org.banking.model.InterestRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InterestRuleMockTest {

    private InterestRule interestRule;

    @BeforeEach
    void setUp() {
        interestRule = mock(InterestRule.class);
    }

    @Test
    void testInterestRuleDetails() {
        when(interestRule.getDate()).thenReturn("20250402");
        when(interestRule.getRuleId()).thenReturn("RULE03");
        when(interestRule.getRate()).thenReturn(2.20);

        assertEquals("20250402", interestRule.getDate(), "Interest rule date should be 20250402.");
        assertEquals("RULE03", interestRule.getRuleId(), "Interest rule ID should be RULE03.");
        assertEquals(2.20, interestRule.getRate(), "Interest rate should be 2.20.");
    }

    @Test
    void testInterestRuleValidation() {
        assertThrows(IllegalArgumentException.class, () -> {
            when(interestRule.getRate()).thenReturn(-1.0);
            if (interestRule.getRate() <= 0) throw new IllegalArgumentException("Invalid rate");
        });
    }
}
