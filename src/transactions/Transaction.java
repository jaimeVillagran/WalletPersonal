package transactions;

import java.time.LocalDateTime;

/**
 * La interfaz Transaction representa una transacción en una billetera.
 */
public interface Transaction {
    /**
     * Devuelve el tipo de la transacción (depósito o retiro).
     *
     * @return el tipo de la transacción
     */
    String getType();

    /**
     * Devuelve el monto de la transacción.
     *
     * @return el monto de la transacción
     */
    double getAmount();

    /**
     * Returns the date of the transaction.
     *
     * @return the date of the transaction
     */
    LocalDateTime getDate();

    /**
     * Returns the description of the transaction.
     *
     * @return the description of the transaction
     */
    String getDescription();
}
