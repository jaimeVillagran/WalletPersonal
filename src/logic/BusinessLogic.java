package logic;

import user.Wallet;
import transactions.TransactionManager;

/**
 * Esta clase representa la lógica de negocio para una aplicación bancaria.
 * Proporciona métodos para depositar, retirar, verificar el saldo en diferentes monedas y establecer la tasa de cambio.
 */
public class BusinessLogic {
  private TransactionManager transactionManager;
  private Wallet wallet;
  private double exchangeRate;

  /**
   * Construye una nueva instancia de BusinessLogic con una instancia de Wallet, TransactionManager y una tasa de cambio dada.
   * @param wallet la instancia de Wallet que se utilizará para las operaciones bancarias.
   * @param transactionManager la instancia de TransactionManager que se utilizará para las operaciones bancarias.
   * @param exchangeRate la tasa de cambio inicial que se utilizará para la conversión de moneda.
   */
  public BusinessLogic(Wallet wallet, TransactionManager transactionManager, double exchangeRate) {
    this.wallet = wallet;
    this.transactionManager = transactionManager;
    this.exchangeRate = exchangeRate;
  }

  /**
   * Deposita una cantidad dada en la billetera.
   * @param amount la cantidad a depositar.
   */
  public void deposit(double amount) {
    transactionManager.deposit(amount);
  }

  /**
   * Retira una cantidad dada de la billetera.
   * Lanza una IllegalArgumentException si la cantidad a retirar es mayor que el saldo actual.
   * @param amount la cantidad a retirar.
   */
  public void withdraw(double amount) {
    double currentBalance = wallet.getBalance();
    if (amount > currentBalance) {
      throw new IllegalArgumentException("La cantidad de retiro supera el saldo actual");
    }
    wallet.withdraw(amount);
  }

  /**
   * Verifica e imprime el saldo actual en la billetera en CLP.
   */
  public void checkBalance() {
    System.out.println("********************************");
    System.out.println("Saldo actual en moneda original: CLP " + String.format("%.2f", wallet.getBalance()));
    System.out.println("********************************");
  }

  /**
   * Verifica e imprime el saldo actual en la billetera en USD.
   * @return el saldo actual en la billetera en USD.
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
   * Establece una nueva tasa de cambio para la conversión de moneda.
   * @param newExchangeRate la nueva tasa de cambio a establecer.
   */
  public void setExchangeRate(double newExchangeRate) {
    this.exchangeRate = newExchangeRate;
  }
}