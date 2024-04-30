package logic;

import user.Wallet;
import transactions.TransactionManager;

/**
 * This class represents the business logic for a banking application.
 * It provides methods to deposit, withdraw, check balance in different currencies, and set the exchange rate.
 */
public class BusinessLogic {
  private TransactionManager transactionManager;
  private Wallet wallet;
  private double exchangeRate;

  /**
   * Constructs a new BusinessLogic instance with a given Wallet, TransactionManager instances and an exchange rate.
   * @param wallet the Wallet instance to be used for banking operations.
   * @param transactionManager the TransactionManager instance to be used for banking operations.
   * @param exchangeRate the initial exchange rate to be used for currency conversion.
   */
  public BusinessLogic(Wallet wallet, TransactionManager transactionManager, double exchangeRate) {
    this.wallet = wallet;
    this.transactionManager = transactionManager;
    this.exchangeRate = exchangeRate;
  }

  /**
   * Deposits a given amount to the wallet.
   * @param amount the amount to be deposited.
   */
  public void deposit(double amount) {
    transactionManager.deposit(amount);
  }

  /**
   * Withdraws a given amount from the wallet.
   * Throws an IllegalArgumentException if the amount to be withdrawn is greater than the current balance.
   * @param amount the amount to be withdrawn.
   */
  public void withdraw(double amount) {
    double currentBalance = wallet.getBalance();
    if (amount > currentBalance) {
      throw new IllegalArgumentException("La cantidad de retiro supera el saldo actual");
    }
    wallet.withdraw(amount);
  }

  /**
   * Checks and prints the current balance in the wallet in CLP.
   */
  public void checkBalance() {
    System.out.println("********************************");
    System.out.println("Saldo actual en moneda original: CLP " + String.format("%.2f", wallet.getBalance()));
    System.out.println("********************************");
  }

  /**
   * Checks and prints the current balance in the wallet in USD.
   * @return the current balance in the wallet in USD.
   */
  public double checkBalanceInUSD() {
    double balanceInCLP = wallet.getBalance();
    double balanceInUSD = balanceInCLP / exchangeRate;
    System.out.println("********************************");
    System.out.println("Saldo actual en dólares: USD " + String.format("%.2f", balanceInUSD));
    System.out.println("********************************");
    return (balanceInUSD);
  }

  /**
   * Sets a new exchange rate for currency conversion.
   * @param newExchangeRate the new exchange rate to be set.
   */
  public void setExchangeRate(double newExchangeRate) {
    this.exchangeRate = newExchangeRate;
  }
}