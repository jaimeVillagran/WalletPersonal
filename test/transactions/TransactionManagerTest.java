package transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.Wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionManagerTest {
    private TransactionManager transactionManager;
    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet(100.0);
        transactionManager = new TransactionManager(wallet);
    }

    @Test
    public void depositIncreasesWalletBalance() {
        transactionManager.deposit(50.0);
        assertEquals(150.0, wallet.getBalance());
    }

    @Test
    public void withdrawDecreasesWalletBalance() {
        transactionManager.withdraw(50.0);
        assertEquals(50.0, wallet.getBalance());
    }

    @Test
    public void depositAddsTransactionToHistory() {
        transactionManager.deposit(50.0);
        assertEquals(1, transactionManager.getTransactions().size());
    }

    @Test
    public void withdrawAddsTransactionToHistory() {
        transactionManager.withdraw(50.0);
        assertEquals(1, transactionManager.getTransactions().size());
    }

    @Test
    public void depositDoesNotChangeBalanceWhenAmountIsZero() {
        transactionManager.deposit(0);
        assertEquals(100.0, wallet.getBalance());
    }

    @Test
    public void withdrawDoesNotChangeBalanceWhenAmountIsZero() {
        transactionManager.withdraw(0);
        assertEquals(100.0, wallet.getBalance());
    }

    @Test
    public void withdrawDoesNotChangeBalanceWhenAmountIsGreaterThanBalance() {
        transactionManager.withdraw(200.0);
        assertEquals(100.0, wallet.getBalance());
    }
}