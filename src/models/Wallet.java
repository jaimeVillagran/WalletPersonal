package models;

/**
 * La clase Wallet representa una billetera personal que permite realizar
 * operaciones de depósito y retiro de dinero.
 * También proporciona métodos para obtener y establecer el saldo actual de la
 * billetera.
 */
public class Wallet {

  // Saldo actual en la billetera
  private double balance;

  /**
   * Crea una nueva instancia de Wallet con un saldo inicial especificado.
   *
   * @param initialBalance el saldo inicial de la billetera
   */
  public Wallet(double initialBalance) {
    this.balance = initialBalance;
  }

  /**
   * Realiza un depósito en la billetera.
   * Si el monto es mayor que cero, se suma al saldo actual y se muestra un
   * mensaje de éxito.
   * Si el monto no es mayor que cero, se muestra un mensaje de error.
   *
   * @param amount el monto a depositar
   */
  public void deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
      System.out.println("Depósito realizado con éxito. Nuevo saldo: CLP " + String.format("%.2f", this.balance));
    } else {
      System.out.println("El monto a depositar debe ser mayor que cero.");
    }
  }

  /**
   * Realiza un retiro de la billetera.
   * Si el monto es mayor que cero y no supera el saldo actual, se resta del saldo
   * y se muestra un mensaje de éxito.
   * Si el monto no es válido o supera el saldo actual, se muestra un mensaje de
   * error.
   *
   * @param amount el monto a retirar
   */
  public void withdraw(double amount) {
    if (amount > 0 && this.balance >= amount) {
      this.balance -= amount;
      System.out.println("Retiro realizado con éxito. Nuevo saldo: CLP " + String.format("%.2f", this.balance));
    } else {
      System.out.println("Saldo insuficiente para realizar el retiro o monto inválido.");
    }
  }

  /**
   * Obtiene el saldo actual de la billetera.
   *
   * @return el saldo actual de la billetera
   */
  public double getBalance() {
    return this.balance;
  }

  /**
   * Establece el saldo de la billetera a un nuevo valor.
   *
   * @param newBalance el nuevo saldo de la billetera
   */
  public void setBalance(double newBalance) {
    this.balance = newBalance;
  }

}