package logic;

import User.Wallet;
import transactions.TransactionManager;

public class BusinessLogic {
  private TransactionManager transactionManager;
  private Wallet wallet;
  private double exchangeRate;

  public BusinessLogic(Wallet wallet, TransactionManager transactionManager, double exchangeRate) {
    this.wallet = wallet;
    this.transactionManager = transactionManager;
    this.exchangeRate = exchangeRate;
  }

  // Método para realizar un depósito
  public void deposit(double amount) {
    transactionManager.deposit(amount);
  }

  // Método para realizar un retiro
  public void withdraw(double amount) {
    double currentBalance = wallet.getBalance();
    if (amount > currentBalance) {
      throw new IllegalArgumentException("La cantidad de retiro supera el saldo actual");
    }
    wallet.withdraw(amount);
  }

  // Método para consultar el saldo en CLP
  public void checkBalance() {
    System.out.println("********************************");
    System.out.println("Saldo actual en moneda original: CLP " + String.format("%.2f", wallet.getBalance()));
    System.out.println("********************************");
  }

  // Método para consultar el saldo en USD
  public void checkBalanceInUSD() {
    double balanceInCLP = wallet.getBalance();
    double balanceInUSD = balanceInCLP / exchangeRate;
    System.out.println("********************************");
    System.out.println("Saldo actual en dólares: USD " + String.format("%.2f", balanceInUSD));
    System.out.println("********************************");
  }

}
