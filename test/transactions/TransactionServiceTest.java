package transactions;

import models.Wallet;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de prueba para el servicio de transacciones.
 * Esta clase contiene métodos de prueba para verificar la funcionalidad del servicio de transacciones.
 */
public class TransactionServiceTest {

    private Wallet wallet;
    private TransactionService transactionService;

    /**
     * Configuración inicial para cada prueba.
     * Inicializa una nueva cartera con un saldo de 0 y un nuevo servicio de transacciones.
     */
    @BeforeEach
    void setUp() {
        wallet = new Wallet(0);  // Inicializamos la cartera con un saldo inicial de 0
        transactionService = new TransactionService(wallet);
    }

    /**
     * Prueba para el depósito de una cantidad positiva.
     * Este método de prueba verifica la funcionalidad de depósito cuando se intenta depositar una cantidad positiva.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se deposita una cantidad positiva en la cartera.
     * 2. Se verifica que el saldo de la cartera sea el esperado después del depósito.
     */
    @Test
    void testDeposit_positiveAmount() {
        transactionService.deposit(1000);
        assertEquals(1000, wallet.getBalance(), "El saldo debe ser 1000 después de depositar 1000");
    }

    /**
     * Prueba para el depósito de una cantidad negativa.
     * Este método de prueba verifica la funcionalidad de depósito cuando se intenta depositar una cantidad negativa.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se intenta depositar una cantidad negativa en la cartera.
     * 2. Se verifica que el saldo de la cartera no haya cambiado, lo que indica que no se permitió el depósito negativo.
     */
    @Test
    void testDeposit_negativeAmount() {
        transactionService.deposit(-100);
        assertEquals(0, wallet.getBalance(), "El saldo debe permanecer en 0 después de intentar depositar un monto negativo");
    }

    /**
     * Prueba para el retiro con saldo suficiente.
     * Este método de prueba verifica la funcionalidad de retiro cuando hay saldo suficiente en la cartera.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se configura un saldo inicial en la cartera.
     * 2. Se retira una cantidad de la cartera que es menor o igual al saldo actual.
     * 3. Se verifica que el saldo de la cartera se haya decrementado correctamente.
     */
    @Test
    void testWithdraw_sufficientBalance() {
        wallet.setBalance(500);  // Configuramos el saldo inicial
        transactionService.withdraw(300);
        assertEquals(200, wallet.getBalance(), "El saldo debe ser 200 después de retirar 300");
    }

    /**
     * Prueba para el retiro con saldo insuficiente.
     * Este método de prueba verifica la funcionalidad de retiro cuando no hay saldo suficiente en la cartera.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se configura un saldo inicial en la cartera.
     * 2. Se intenta retirar una cantidad de la cartera que es mayor al saldo actual.
     * 3. Se verifica que el saldo de la cartera no haya cambiado, lo que indica que no se permitió el retiro.
     */
    @Test
    void testWithdraw_insufficientBalance() {
        wallet.setBalance(200);  // Configuramos el saldo inicial
        transactionService.withdraw(300);
        assertEquals(200, wallet.getBalance(), "El saldo debe permanecer en 200 después de un intento fallido de retiro");
    }

    /**
     * Prueba para el depósito de una cantidad extremadamente alta.
     * Este método de prueba verifica la funcionalidad de depósito cuando se intenta depositar una cantidad extremadamente alta.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se deposita la cantidad máxima posible en la cartera.
     * 2. Se verifica que el saldo de la cartera sea igual al monto depositado.
     */
    @Test
    void testDeposit_ExtremelyHighAmount() {
        transactionService.deposit(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, wallet.getBalance(), "El saldo debe ser igual al monto depositado, incluso si es extremadamente alto.");
    }

    /**
     * Prueba para el retiro de una cantidad extremadamente alta.
     * Este método de prueba verifica la funcionalidad de retiro cuando se intenta retirar una cantidad extremadamente alta.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se configura el saldo de la cartera al máximo posible.
     * 2. Se retira la cantidad máxima posible de la cartera.
     * 3. Se verifica que el saldo de la cartera sea 0 después del retiro.
     */
    @Test
    void testWithdraw_ExtremelyHighAmount() {
        wallet.setBalance(Double.MAX_VALUE);
        transactionService.withdraw(Double.MAX_VALUE);
        assertEquals(0, wallet.getBalance(), "Después de retirar el saldo máximo, el saldo debe ser 0.");
    }

    /**
     * Prueba para el depósito de la cantidad mínima.
     * Este método de prueba verifica la funcionalidad de depósito cuando se intenta depositar la cantidad mínima.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se deposita la cantidad mínima posible en la cartera.
     * 2. Se verifica que el saldo de la cartera sea igual al monto depositado.
     */
    @Test
    void testDeposit_MinimumAmount() {
        transactionService.deposit(0.01);
        assertEquals(0.01, wallet.getBalance(), "El saldo debe reflejar un depósito mínimo correctamente.");
    }

    /**
     * Prueba para el retiro de la cantidad mínima con saldo suficiente.
     * Este método de prueba verifica la funcionalidad de retiro cuando se intenta retirar la cantidad mínima y hay saldo suficiente en la cartera.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se configura un saldo inicial en la cartera.
     * 2. Se retira la cantidad mínima posible de la cartera.
     * 3. Se verifica que el saldo de la cartera se haya decrementado correctamente.
     */
    @Test
    void testWithdraw_MinimumAmount_WhenSufficientBalance() {
        wallet.setBalance(1.00);  // Asegúrate de tener un saldo suficiente
        transactionService.withdraw(0.01);
        assertEquals(0.99, wallet.getBalance(), "El saldo debe reflejar un retiro mínimo correctamente.");
    }

    /**
     * Prueba para el depósito de una cantidad negativa.
     * Este método de prueba verifica la funcionalidad de depósito cuando se intenta depositar una cantidad negativa.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se intenta depositar una cantidad negativa en la cartera.
     * 2. Se verifica que el saldo de la cartera no haya cambiado, lo que indica que no se permitió el depósito negativo.
     */
    @Test
    void testDeposit_NegativeAmount() {
        transactionService.deposit(-50);
        assertEquals(0, wallet.getBalance(), "No se debe permitir un depósito negativo, el saldo debe permanecer inalterado.");
    }

    /**
     * Prueba para el retiro de una cantidad negativa.
     * Este método de prueba verifica la funcionalidad de retiro cuando se intenta retirar una cantidad negativa.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se configura un saldo inicial en la cartera.
     * 2. Se intenta retirar una cantidad negativa de la cartera.
     * 3. Se verifica que el saldo de la cartera no haya cambiado, lo que indica que no se permitió el retiro negativo.
     */
    @Test
    void testWithdraw_NegativeAmount() {
        wallet.setBalance(100);
        transactionService.withdraw(-50);
        assertEquals(100, wallet.getBalance(), "No se debe permitir un retiro negativo, el saldo debe permanecer inalterado.");
    }

    /**
     * Prueba para el depósito con decimales.
     * Este método de prueba verifica la funcionalidad de depósito cuando se intenta depositar una cantidad con decimales.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se deposita una cantidad con decimales en la cartera.
     * 2. Se verifica que el saldo de la cartera sea igual al monto depositado.
     */
    @Test
    void testDeposit_WithDecimal() {
        transactionService.deposit(1000.99);
        assertEquals(1000.99, wallet.getBalance(), "El saldo debe incluir centavos correctamente después del depósito.");
    }

    /**
     * Prueba para el retiro con decimales y saldo suficiente.
     * Este método de prueba verifica la funcionalidad de retiro cuando se intenta retirar una cantidad con decimales y hay saldo suficiente en la cartera.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se configura un saldo inicial en la cartera.
     * 2. Se retira una cantidad con decimales de la cartera.
     * 3. Se verifica que el saldo de la cartera se haya decrementado correctamente.
     */
    @Test
    void testWithdraw_WithDecimal_WhenSufficientBalance() {
        wallet.setBalance(2000.99);
        transactionService.withdraw(500.55);
        assertEquals(1500.44, wallet.getBalance(), "El saldo debe incluir centavos correctamente después del retiro.");
    }
}
