package transactions;

/**
 * La interfaz Transaction representa una transacción en una billetera personal.
 * 
 * Esta interfaz define los métodos necesarios para obtener el monto de la
 * transacción,
 * la descripción de la transacción y ejecutar la transacción.
 */
public interface Transaction {
    /**
     * Obtiene el monto de la transacción.
     * 
     * @return el monto de la transacción
     */
    double getAmount();

    /**
     * Obtiene la descripción de la transacción.
     * 
     * @return la descripción de la transacción
     */
    String getDescription();

    /**
     * Ejecuta la transacción.
     */
    void execute();
}
