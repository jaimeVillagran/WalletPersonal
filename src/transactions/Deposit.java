package transactions;

/**
 * La clase Deposit representa una transacción de depósito en una billetera
 * personal.
 * Implementa la interfaz Transaction.
 */
public class Deposit implements Transaction {
    private double amount;
    private String description;

    /**
     * Crea una nueva instancia de la clase Deposit con el monto especificado.
     * La descripción de la transacción se genera automáticamente.
     * 
     * @param amount el monto del depósito
     */
    public Deposit(double amount) {
        this.amount = amount;
        this.description = "Depósito de " + amount;
    }

    /**
     * Obtiene el monto del depósito.
     * 
     * @return el monto del depósito
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * Obtiene la descripción de la transacción.
     * 
     * @return la descripción de la transacción
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Ejecuta la transacción de depósito.
     * Aquí se implementaría la lógica para ejecutar el depósito.
     */
    @Override
    public void execute() {
        System.out.println("Ejecutando depósito: " + description);
    }
}