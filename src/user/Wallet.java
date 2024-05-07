package user;

public class Wallet {
  private double balance;

  public Wallet(double initialBalance) {
    this.balance = initialBalance;
  }

  /**
   * Intenta depositar una cantidad en la billetera.
   * Solo se permite depositar montos positivos.
   *
   * @param amount la cantidad a depositar
   * @return true si el depósito es exitoso, false si el monto es negativo
   */
  public boolean deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
      System.out.println("\nDepósito realizado de CLP: " + amount + "\n");
      return true;
    } else {
      System.out.println("\u001B[31m" + "*****************************************");
      System.out.println("Monto a depositar no puede ser negativo");
      System.out.println("*****************************************" + "\u001B[0m");
      return false;
    }
  }

  /**
   * Intenta retirar una cantidad de la billetera.
   * La operación solo es exitosa si hay suficientes fondos.
   *
   * @param amount la cantidad a retirar
   * @return true si el retiro es exitoso, false si los fondos son insuficientes
   */
  public boolean withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
      this.balance -= amount;
      System.out.println("Retiro de " + amount + " CLP realizado.");
      return true;
    } else {
      System.out.println("No se pudo retirar " + amount + " CLP por fondos insuficientes o monto negativo.");
      return false;
    }
  }

  /**
   * Obtiene el saldo actual de la billetera.
   *
   * @return el saldo actual
   */
  public double getBalance() {
    return balance;
  }
}