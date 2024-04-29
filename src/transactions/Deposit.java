package transactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * La clase Deposit implementa la interfaz Transaction y representa un depósito.
 * Contiene métodos para obtener detalles sobre el depósito como el tipo, la
 * cantidad, la fecha y la descripción.
 */
public class Deposit implements Transaction {
    private double amount;
    private LocalDateTime date;

    /**
     * Constructor para la clase Deposit.
     * Inicializa la cantidad del depósito y establece la fecha a la hora actual.
     *
     * @param amount la cantidad del depósito.
     */
    public Deposit(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    /**
     * Devuelve el tipo de la transacción.
     * En este caso, siempre devolverá "Depósito".
     *
     * @return una cadena de texto que representa el tipo de la transacción.
     */
    @Override
    public String getType() {
        return "Depósito";
    }

    /**
     * Devuelve la cantidad del depósito.
     *
     * @return un valor double que representa la cantidad del depósito.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Devuelve la fecha del depósito.
     *
     * @return un objeto LocalDateTime que representa la fecha del depósito.
     */
    @Override
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Devuelve la descripción del depósito.
     * La descripción incluye la cantidad del depósito y la fecha en que se realizó.
     *
     * @return una cadena de texto que representa la descripción del depósito.
     */
    @Override
    public String getDescription() {
        // Define el formato de fecha y hora deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'a las' HH:mm");
        // Formatea la fecha y hora según el formato deseado
        String formattedDateTime = date.format(formatter);
        // Retorna la descripción con el formato ajustado
        return String.format("%s de CLP %.2f el %s", getType(), amount, formattedDateTime);
    }
}