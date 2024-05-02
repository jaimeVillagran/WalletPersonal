package transactions;

import user.Wallet;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase TransactionManager se encarga de administrar las transacciones de
 * una billetera personal.
 * Permite agregar y ejecutar transacciones, actualizar la billetera después de
 * cada transacción,
 * obtener el historial de transacciones y imprimir el historial de
 * transacciones.
 */
public class TransactionManager {
    private Wallet wallet;
    private List<Transaction> transactions;

    /**
     * Crea una instancia de TransactionManager con la billetera especificada.
     * 
     * @param wallet la billetera personal
     */
    public TransactionManager(Wallet wallet) {
        this.wallet = wallet;
        this.transactions = new ArrayList<>();
    }

    /**
     * Agrega una transacción a la lista de transacciones, la ejecuta y actualiza la
     * billetera.
     * 
     * @param transaction la transacción a agregar y ejecutar
     */
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        transaction.execute();
        updateWallet(transaction);
    }

    /**
     * Actualiza la billetera después de cada transacción.
     * Si la transacción es un depósito, se agrega el monto a la billetera.
     * Si la transacción es un retiro, se resta el monto de la billetera.
     * 
     * @param transaction la transacción realizada
     */
    private void updateWallet(Transaction transaction) {
        if (transaction instanceof Deposit) {
            wallet.deposit(transaction.getAmount());
        } else if (transaction instanceof Withdrawal) {
            wallet.withdraw(transaction.getAmount());
        }
    }

    /**
     * Obtiene una copia del historial de transacciones.
     * 
     * @return una lista con las transacciones realizadas
     */
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    /**
     * Obtiene el número de transacciones realizadas.
     * 
     * @return el número de transacciones
     */
    public int getTransactionsCount() {
        return transactions.size();
    }

    /**
     * Imprime el historial de transacciones.
     * Si no hay transacciones registradas, muestra un mensaje indicando que no se
     * han registrado transacciones.
     * Si hay transacciones registradas, muestra el historial con la descripción y
     * el monto de cada transacción.
     */
    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No se han registrado transacciones.");
        } else {
            System.out.println("Historial de Transacciones:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getDescription() + " - Monto: " + transaction.getAmount());
            }
        }
    }
}