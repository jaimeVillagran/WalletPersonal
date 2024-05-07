package transactions;

import models.Wallet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * La clase TransactionService implementa la interfaz ITransactionService y
 * proporciona una implementación concreta
 * de los métodos para depositar, retirar, obtener el saldo actual, obtener el
 * historial de transacciones y obtener el saldo actual en USD.
 *
 * Esta clase mantiene una referencia a la billetera del usuario y una lista del
 * historial de transacciones.
 */
public class TransactionService implements ITransactionService {
    // Billetera del usuario
    private final Wallet wallet;
    // Historial de transacciones del usuario
    private final List<String> transactionHistory;
    // Formato de la fecha y hora para el registro de transacciones
    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("'Fecha:' dd/MM/yyyy ' /Hora: ' HH:mm: ' / Transaccion'");
    // Tasa de cambio para convertir el saldo a USD
    private static final double EXCHANGE_RATE = 0.00106;

    /**
     * Constructor de TransactionService.
     * Inicializa la billetera del usuario y la lista del historial de
     * transacciones.
     *
     * @param wallet la billetera del usuario
     */
    public TransactionService(Wallet wallet) {
        this.wallet = wallet;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Realiza un depósito en la billetera del usuario.
     * Este método toma un monto y lo suma al saldo actual del usuario.
     * También registra la transacción en el historial de transacciones.
     *
     * @param amount el monto a depositar
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            wallet.deposit(amount);
            String timestamp = LocalDateTime.now().format(formatter);
            transactionHistory.add(timestamp + " Depósito: +$" + String.format("%.2f", amount));
        }
    }

    /**
     * Realiza un retiro de la billetera del usuario.
     * Este método toma un monto y lo resta del saldo actual del usuario si el saldo
     * es suficiente.
     * También registra la transacción en el historial de transacciones.
     *
     * @param amount el monto a retirar
     */
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && wallet.getBalance() >= amount) {
            wallet.withdraw(amount);
            String timestamp = LocalDateTime.now().format(formatter);
            transactionHistory.add(timestamp + " Retiro: -$" + String.format("%.2f", amount));
        }
    }

    /**
     * Obtiene el saldo actual de la billetera del usuario.
     *
     * @return el saldo actual de la billetera del usuario
     */
    @Override
    public double getCurrentBalance() {
        return wallet.getBalance();
    }

    /**
     * Obtiene el historial de transacciones del usuario.
     *
     * @return una lista de cadenas que representa el historial de transacciones del
     *         usuario
     */
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    /**
     * Obtiene el saldo actual de la billetera del usuario en USD.
     * Este método convierte el saldo actual a USD utilizando la tasa de cambio
     * EXCHANGE_RATE.
     *
     * @return el saldo actual de la billetera del usuario en USD
     */
    public double getCurrentBalanceInUSD() {
        return getCurrentBalance() * EXCHANGE_RATE;
    }
}