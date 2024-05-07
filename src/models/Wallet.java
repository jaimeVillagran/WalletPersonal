package models;

public class Wallet {

  private double balance;

  public Wallet(double initialBalance) {
    this.balance = initialBalance;
  }

  public void deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
      System.out.println("Depósito realizado con éxito. Nuevo saldo: CLP " + String.format("%.2f", this.balance));
    } else {
      System.out.println("El monto a depositar debe ser mayor que cero.");
    }
  }

  public void withdraw(double amount) {
    if (amount > 0 && this.balance >= amount) {
      this.balance -= amount;
      System.out.println("Retiro realizado con éxito. Nuevo saldo: CLP " + String.format("%.2f", this.balance));
    } else {
      System.out.println("Saldo insuficiente para realizar el retiro o monto inválido.");
    }
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double newBalance) {
    this.balance = newBalance;
  }

}
