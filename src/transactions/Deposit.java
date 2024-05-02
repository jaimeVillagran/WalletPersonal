package transactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Representa una transacción de depósito.
 * Implementa la interfaz Transaction.
 */

public class Deposit implements Transaction {
    private double amount;
    private LocalDateTime date;

    /**
     * Construye una transacción de depósito con una cantidad específica.
     * 
     * @param amount La cantidad a depositar.
     */
    public Deposit(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    // Implementaciones de los métodos de la interfaz Transaction

    /**
     * Obtiene el tipo de la transacción.
     * 
     * @return El tipo de la transacción (en este caso, "Depósito").
     */
    @Override
    public String getType() {
        return "Depósito";
    }

    /**
     * Obtiene la cantidad de la transacción.
     * 
     * @return La cantidad del depósito.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Obtiene la fecha y hora de la transacción.
     * 
     * @return La fecha y hora del depósito.
     */
    @Override
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Obtiene la descripción de la transacción.
     * 
     * @return La descripción del depósito, incluyendo el tipo, cantidad y fecha.
     */
    @Override
    public String getDescription() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'a las' HH:mm");
        String formattedDateTime = date.format(formatter);
        return String.format(Locale.US, "%s of CLP %.2f on %s", getType(), amount, formattedDateTime);
    }
}