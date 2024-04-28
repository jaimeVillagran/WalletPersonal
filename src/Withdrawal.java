import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * La clase Withdrawal implementa la interfaz Transaction y representa un retiro.
 * Contiene métodos para obtener detalles sobre el retiro como el tipo, la cantidad, la fecha y la descripción.
 */
public class Withdrawal implements Transaction {
    private double amount;
    private LocalDateTime date;

    /**
     * Constructor para la clase Withdrawal.
     * Inicializa la cantidad del retiro y establece la fecha a la hora actual.
     *
     * @param amount la cantidad del retiro.
     */
    public Withdrawal(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    /**
     * Devuelve el tipo de la transacción.
     * En este caso, siempre devolverá "Retiro".
     *
     * @return una cadena de texto que representa el tipo de la transacción.
     */
    @Override
    public String getType() {
        return "Retiro";
    }

    /**
     * Devuelve la cantidad del retiro.
     *
     * @return un valor double que representa la cantidad del retiro.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Devuelve la fecha del retiro.
     *
     * @return un objeto LocalDateTime que representa la fecha del retiro.
     */
    @Override
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Devuelve la descripción del retiro.
     * La descripción incluye la cantidad del retiro y la fecha en que se realizó.
     *
     * @return una cadena de texto que representa la descripción del retiro.
     */
    @Override
    public String getDescription() {
        // Define el formato de fecha y hora deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'a las' 'T'HH:mm");
        // Formatea la fecha y hora según el formato deseado
        String formattedDateTime = date.format(formatter);
        // Retorna la descripción con el formato ajustado
        return String.format("%s de CLP %.2f el %s", getType(), amount, formattedDateTime);
    }
}