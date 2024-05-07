package transactions;

/**
 * La clase Withdrawal representa una transacción de retiro en una billetera
 * personal.
 * Implementa la interfaz Transaction y proporciona métodos para obtener el
 * monto y la descripción del retiro,
 * así como para ejecutar la transacción.
 */
public class Withdrawal implements Transaction {
    private double amount;
    private String description;

    /**
     * Crea una nueva instancia de Withdrawal con el monto especificado.
     * La descripción del retiro se establece automáticamente como "Retiro de
     * [monto]".
     * 
     * @param amount el monto del retiro
     */
    public Withdrawal(double amount) {
        this.amount = amount;
        this.description = "Retiro de " + amount;
    }

    /**
     * Obtiene el monto del retiro.
     * 
     * @return el monto del retiro
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Obtiene la descripción del retiro.
     * 
     * @return la descripción del retiro
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Ejecuta la transacción de retiro.
     * Aquí se implementaría la lógica para ejecutar el retiro.
     */
    @Override
    public void execute() {
        System.out.println("Ejecutando retiro: " + description);
    }
}