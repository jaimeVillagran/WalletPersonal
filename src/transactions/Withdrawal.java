package transactions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * La clase Withdrawal implementa la interfaz Transaction y representa un r
 * etiro.
 * Contiene métodos para obtener detalles sobre el retiro como el tipo, la
 * cantidad, la fecha y la descripción.
 */
public class Withdrawal implements Transaction {
    private double amount;
    private LocalDateTime date;

    /**
     * Constructor for the Withdrawal class.
     * Initializes the withdrawal amount and sets the date to the current time.
     *
     * @param amount the withdrawal amount.
     */
    public Withdrawal(double amount) {
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    /**
     * Returns the type of the transaction.
     * In this case, it always returns "Retiro" (Withdrawal in Spanish).
     *
     * @return a string representing the type of the transaction.
     */
    @Override
    public String getType() {
        return "Retiro";
    }

    /**
     * Returns the withdrawal amount.
     *
     * @return a double value representing the withdrawal amount.
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the date of the withdrawal.
     *
     * @return a LocalDateTime object representing the date of the withdrawal.
     */
    @Override
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Returns the description of the withdrawal.
     * The description includes the withdrawal amount and the date it was made.
     *
     * @return a string representing the description of the withdrawal.
     */
    @Override
    public String getDescription() {
        // Define the desired date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'a las' HH:mm");
        // Format the date and time according to the desired format
        String formattedDateTime = date.format(formatter);
        // Return the description with the adjusted format
        return String.format("%s de CLP %.2f el %s", getType(), amount, formattedDateTime);
    }
}