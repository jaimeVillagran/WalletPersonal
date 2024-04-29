package transactions;

import java.util.ArrayList;
import java.util.List;
import User.Wallet;

/**
 * La clase TransactionManager representa un administrador de transacciones
 * asociadas con una billetera.
 * Permite realizar depósitos, retiros y mostrar el historial de transacciones.
 */
public class TransactionManager {

  private Wallet wallet;
  private List<Transaction> transactions;

  /**
   * Construye un objeto TransactionManager asociado con una billetera y una lista
   * vacía de transacciones.
   *
   * @param wallet la billetera para asociar con el administrador de transacciones
   */
  public TransactionManager(Wallet wallet) {
    this.wallet = wallet;
    this.transactions = new ArrayList<>(); // Crea una nueva lista de transacciones para la billetera
  }

  /**
   * Realiza un depósito del monto especificado en la billetera asociada.
   *
   * @param amount el monto a depositar
   */
  public void deposit(double amount) {
    if (amount > 0) {
      Transaction deposit = new Deposit(amount);
      transactions.add(deposit);
      wallet.setBalance(wallet.getBalance() + amount);
      System.out.println("Depósito exitoso.");
      System.out.println(deposit.getDescription());
    } else {
      System.out.println("El monto a depositar debe ser mayor a cero.");
    }
  }

  /**
   * Realiza un retiro del monto especificado de la billetera asociada.
   * Si el retiro es exitoso, muestra un mensaje de exito y la descripción de la
   * transacción.
   * 
   *
   * @param amount el monto a retirar
   */
  public void withdraw(double amount) {
    double currentBalance = wallet.getBalance();
    if (amount > 0 && amount <= currentBalance) {
      Transaction withdrawal = new Withdrawal(amount);
      transactions.add(withdrawal);
      wallet.setBalance(currentBalance - amount);
      System.out.println("Retiro exitoso.");
      System.out.println(withdrawal.getDescription());
    } else {
      // Si el monto es menor o igual a cero, muestra un mensaje de error
      System.out.println("El monto a retirar debe ser mayor a cero y no puede exceder el saldo actual.");
    }
  }

  /**
   * Muestra el historial de transacciones.
   * Si no hay transacciones, muestra un mensaje indicando que no hay
   * transacciones.
   */
  public void showTransaction() {
    System.out.println("Historial de transacciones: ");
    for (Transaction transaction : transactions) {
      System.out.println(transaction.getDescription());
    }
  }

}