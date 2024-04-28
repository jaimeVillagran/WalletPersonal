import java.util.ArrayList;
import java.util.List;

public class Wallet {
  private double balance;
  private final List<Transaction> transactions;

  public Wallet() {
    this.balance = 0;
    this.transactions = new ArrayList<>();
  }

  public void deposit(double amount) {
    if (amount > 0) {
      Deposit deposit = new Deposit(amount); // Crea un nuevo objeto de la clase
      transactions.add(deposit); // Agrega la transacción al historial de
      balance += amount; // Actualiza el saldo de la billeter
      System.out.println("Depósito exitoso."); // Imprime el mensaje de exito
      System.out.println(deposit.getDescription()); // Imprime la descripción
    } else {
      System.out.println("No se puede realizar el depósito."); // Imprime el mensaje de error
      System.out.println("La cantidad a depositar debe ser mayor a 0."); // Imprime el mensaje de error
    }

  }

  public void withdraw(double amount) {
    if (amount <= balance && amount > 0) {
      Withdrawal withdrawal = new Withdrawal(amount); // Crea un nuevo objeto de la clase
      transactions.add(withdrawal); // Agrega la transacción al historial de
      balance -= amount; // Actualiza el saldo de la billeter
      System.out.println("Retiro exitoso."); // Imprime el mensaje de exito
      System.out.println(withdrawal.getDescription()); // Imprime la descripción
    } else {
      System.out.println("No se puede realizar el retiro."); // Imprime el mensaje de error
      System.out.println("La cantidad a retirar debe ser mayor a 0 y menor o igual al saldo."); // Imprime el mensaje de
                                                                                                // error
    }

  }

  public double getBalance() {
    return balance; // Devuelve el saldo actual
  }

  public void checkBalance() {
    System.out.println("****************");
    System.out.println("* Billetera Wallet Personal *");
    System.out.println("****************");
    System.out.println("Saldo actual: " + balance);
    System.out.println("****************");
  }

  public void showTransactions() {
    System.out.println("****************");
    System.out.println("* Transacciones *");
    System.out.println("****************");
    for (Transaction transaction : transactions) {
      System.out.println(transaction.getDescription());
    }
  }

}