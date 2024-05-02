package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet(0.0); // Inicializa una billetera con saldo inicial de 0.0
        wallet.deposit(100.0); // Deposita 100.0 en la billetera
    }

    @Test
    public void testGetBalance() {
        assertEquals(100.0, wallet.getBalance());
    }

   /* @Test
    public void testSetBalance() {
        wallet.setBalance(200.0);
        assertEquals(200.0, wallet.getBalance());
    }*/

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
    @Test
    public void testWithdrawMoreThanBalance() {
        boolean result = wallet.withdraw(150.0);  // Asumiendo que 'withdraw' retorna un booleano
        assertEquals(false, result);
        assertEquals(100.0, wallet.getBalance(), "El saldo no debe cambiar si el retiro excede el saldo.");
    }

    @Test
    public void testDepositNegativeAmount() {
        wallet.deposit(-50.0);
        assertEquals(100.0, wallet.getBalance(), "No se debe permitir depositar una cantidad negativa.");
    }

    @Test
    public void testWithdrawNegativeAmount() {
        boolean result = wallet.withdraw(-50.0);
        assertFalse(result, "El retiro con una cantidad negativa debería fallar.");
        assertEquals(100.0, wallet.getBalance(), "El saldo no debe cambiar después de intentar retirar una cantidad negativa.");
    }
}