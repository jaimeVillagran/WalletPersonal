package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet(100.0);
    }

    @Test
    public void testGetBalance() {
        assertEquals(100.0, wallet.getBalance());
    }

    @Test
    public void testSetBalance() {
        wallet.setBalance(200.0);
        assertEquals(200.0, wallet.getBalance());
    }

    @Test
    public void testDeposit() {
        wallet.deposit(50.0);
        assertEquals(150.0, wallet.getBalance());
    }

    @Test
    public void testWithdraw() {
        wallet.withdraw(50.0);
        assertEquals(50.0, wallet.getBalance());
    }
}