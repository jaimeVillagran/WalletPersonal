/**
 * Esta clase proporciona servicios relacionados con las transacciones.
 */
package transactions;

import models.Wallet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * La interfaz Transaction representa una transacción en una billetera personal.
 * 
 * Esta interfaz define los métodos necesarios para obtener el monto de la
 * transacción,
 * la descripción de la transacción y ejecutar la transacción.
 */
public interface TransactionService {
    private Wallet wallet;
    private List<String> transactionHistory;
    private DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("'Fecha:' dd/MM/yyyy ' /Hora: ' HH:mm: ' / Transaccion'");
    private static final double EXCHANGE_RATE = 0.00106;

    public TransactionService(Wallet wallet) {
        this.wallet = wallet;
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Realiza un depósito en la billetera personal.
     * 
     * @param amount la cantidad de dinero a depositar
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
     * Realiza un retiro de dinero de la billetera.
     * 
     * @param amount la cantidad de dinero a retirar
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
        * Obtiene el saldo actual de la billetera.
        *
        * @return el saldo actual de la billetera
        */
    @Override
    public double getCurrentBalance() {
        return wallet.getBalance();
    }

    /**
     * Obtiene el historial de transacciones.
     * 
     * @return una lista de cadenas que representa el historial de transacciones
     */
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    /**
        * Calcula el saldo actual en dólares estadounidenses.
        * 
        * @return el saldo actual en dólares estadounidenses.
        */
    public double getCurrentBalanceInUSD() {
        return getCurrentBalance() * EXCHANGE_RATE;
    }
}
