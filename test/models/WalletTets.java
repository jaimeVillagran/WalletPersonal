package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase de prueba para la billetera.
 * Esta clase contiene métodos de prueba para verificar la funcionalidad de la billetera.
 */
public class WalletTets {

    /**
     * Prueba para el depósito de una cantidad positiva.
     * Este método de prueba verifica la funcionalidad de depósito cuando se intenta depositar una cantidad positiva.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se crea una nueva billetera con un saldo inicial.
     * 2. Se deposita una cantidad positiva en la billetera.
     * 3. Se verifica que el saldo de la billetera se haya incrementado correctamente.
     */
    @Test
    void testDepositPositiveAmount() {
        Wallet wallet = new Wallet(100);
        wallet.deposit(50);
        assertEquals(150, wallet.getBalance(), "El saldo debe incrementarse correctamente.");
    }

    /**
     * Prueba para el depósito de una cantidad negativa.
     * Este método de prueba verifica la funcionalidad de depósito cuando se intenta depositar una cantidad negativa.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se crea una nueva billetera con un saldo inicial.
     * 2. Se intenta depositar una cantidad negativa en la billetera.
     * 3. Se verifica que el saldo de la billetera no haya cambiado, lo que indica que no se permitió el depósito negativo.
     */
    @Test
    void testDepositNegativeAmount() {
        Wallet wallet = new Wallet(100);
        wallet.deposit(-50);
        assertEquals(100, wallet.getBalance(), "No se debe permitir depositar un monto negativo.");
    }

    /**
     * Prueba para el retiro con fondos suficientes.
     * Este método de prueba verifica la funcionalidad de retiro cuando hay fondos suficientes en la billetera.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se crea una nueva billetera con un saldo inicial.
     * 2. Se retira una cantidad de la billetera que es menor o igual al saldo actual.
     * 3. Se verifica que el saldo de la billetera se haya decrementado correctamente.
     */
    @Test
    void testWithdrawSufficientFunds() {
        Wallet wallet = new Wallet(200);
        wallet.withdraw(50);
        assertEquals(150, wallet.getBalance(), "El saldo debe decrementarse correctamente cuando hay fondos suficientes.");
    }

    /**
     * Prueba para el retiro con fondos insuficientes.
     * Este método de prueba verifica la funcionalidad de retiro cuando no hay fondos suficientes en la billetera.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se crea una nueva billetera con un saldo inicial.
     * 2. Se intenta retirar una cantidad de la billetera que es mayor al saldo actual.
     * 3. Se verifica que el saldo de la billetera no haya cambiado, lo que indica que no se permitió el retiro.
     */
    @Test
    void testWithdrawInsufficientFunds() {
        Wallet wallet = new Wallet(100);
        wallet.withdraw(150);
        assertEquals(100, wallet.getBalance(), "No se debe permitir retirar más de lo disponible en el saldo.");
    }
}
