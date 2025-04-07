package tp0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private BankAccount targetAccount;
    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0, 0.05);
        targetAccount = new BankAccount(500.0, 0.03);
    }
    @Test
    void testDepositValidAmount() {
        account.deposit(200.0);
        assertEquals(1200.0, account.getBalance(), 0.0001);
    }
    @Test
    void testDepositNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }
    @Test
    void testWithdrawValidAmount() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.0001);
    }
    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(2000.0));
    }

    @Test
    void testWithdrawNegativeAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100.0));
    }
    @Test
    void testTransferValidAmount() {
        account.transfer(200.0, targetAccount);
        assertEquals(800.0, account.getBalance(), 0.0001);
        assertEquals(700.0, targetAccount.getBalance(), 0.0001);
    }

    @Test
    void testTransferToNullAccountThrowsException() {
        assertThrows(NullPointerException.class, () -> account.transfer(100.0, null));
    }

    @Test
    void testTransferInsufficientBalanceThrowsException() {
        assertThrows(IllegalStateException.class, () -> account.transfer(1500.0, targetAccount));
    }

    @Test
    void testAddInterest() {
        account.addInterest(); // 1000 + 5%
        assertEquals(1050.0, account.getBalance(), 0.0001);
    }


}