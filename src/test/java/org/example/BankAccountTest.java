package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Required for non-static @BeforeAll and @AfterAll
public class BankAccountTest {
    private BankAccount account;

    @BeforeAll
    public void globalSetup() {
        // Setup that is run once before all tests in the class
        System.out.println("Starting BankAccount tests.");
    }

    @BeforeEach
    public void setup() {
        // A fresh account for each test
        account = new BankAccount(100.00);
    }

    @Test
    @DisplayName("Deposit adds to the balance correctly")
    public void testDeposit() {
        account.deposit(50);
        assertEquals(150.00, account.getBalance(), 0.01, "Balance should be 150 after depositing 50");
    }

    @Test
    @DisplayName("Withdraw reduces the balance correctly")
    public void testWithdraw() {
        account.withdraw(30);
        assertEquals(70.00, account.getBalance(), 0.01, "Balance should be 70 after withdrawing 30");
    }

    @Test
    @DisplayName("Withdrawal that exceeds balance throws IllegalArgumentException")
    public void testWithdrawException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200);
        });
        assertTrue(exception.getMessage().contains("Invalid withdrawal amount"));
    }

    @AfterEach
    public void tearDown() {
        // Clean up if there were external resources used
        account = null;
    }

    @AfterAll
    public void globalTearDown() {
        // Cleanup that runs once after all tests in the class
        System.out.println("Finished BankAccount tests.");
    }

    @Nested
    @DisplayName("Advanced operations tests")
    class AdvancedOperations {
        @Test
        @DisplayName("Test complex transaction sequence")
        void testComplexTransaction() {
            account.deposit(50);
            account.withdraw(30);
            assertEquals(120.00, account.getBalance(), 0.01);
        }

        @Test
        @Tag("disabled")
        @Disabled("Feature under development")
        void testFeatureUnderDevelopment() {
            // This test will be skipped
        }
    }
}
