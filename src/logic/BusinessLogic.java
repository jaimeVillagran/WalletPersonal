package logic;

import transactions.TransactionManager;
import user.Wallet;

public class BusinessLogic {
  private Wallet wallet;
  private TransactionManager transactionManager;
  private double exchangeRate;  // Suponiendo que necesitamos manejar conversiones de moneda

  public BusinessLogic(Wallet wallet, TransactionManager transactionManager, double exchangeRate) {
    this.wallet = wallet;
    this.transactionManager = transactionManager;
    this.exchangeRate = exchangeRate;
  }

  public boolean performDeposit(double amount) {
    if (!wallet.deposit(amount)) {
      System.out.println("\u001B[31m" + "*******************************************");
      System.out.println("No se pudo depositar CLP " + amount);
      System.out.println("Monto a depositar no puede ser negativo");
      System.out.println("*******************************************" + "\u001B[0m");
      return false; // Retorna false si el monto es negativo
    } else {
      System.out.println("Depósito realizado de CLP: " + amount + "\n");
      return true;  // Retorno true si el depósito es exitoso
    }
  }

  public boolean performWithdrawal(double amount) {
    if (wallet.withdraw(amount)) {
      System.out.println("Retiro realizado de CLP:  " + amount + "\n");
      return true; // Retorna true si el retiro es exitoso

    } else {
      System.out.println("\u001B[31m" + "*******************************************");
      System.out.println("No se pudo retirar CLP " + amount);
      System.out.println("Fondos insuficientes para realizar el retiro.");
      System.out.println("*******************************************" + "\u001B[0m");
      return false; // Retorna false si los fondos son insuficientes
    }
  }

  public double checkBalanceCLP() {
    return wallet.getBalance(); // Retorna el saldo actual en CLP
  }

  public double getBalanceUSD() {
    return convertCurrencyToUSD(checkBalanceCLP()); // Convierte el saldo en CLP a USD
  }

  public double convertCurrencyToUSD(double amountInLocalCurrency) {
    return amountInLocalCurrency / exchangeRate;
  }
}