package transactions;

import java.time.LocalDateTime;

public interface Transaction {
    // Método para obtener el tipo de transacción (depósito o retiro)
    String getType();

    // Método para obtener el monto de la transacción
    double getAmount();

    // Método para obtener la fecha de la transacción
    LocalDateTime getDate();

    // Método para obtener la descripción de la transacción
    String getDescription();
}