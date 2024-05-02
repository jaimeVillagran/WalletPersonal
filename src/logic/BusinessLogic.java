package logic;

import transactions.TransactionManager;
import user.Wallet;

/**
 * La clase BusinessLogic representa la lógica de negocio de la aplicación
 * WalletPersonal.
 * Contiene métodos para realizar depósitos, retiros y consultar el saldo en
 * diferentes monedas.
 */
public class BusinessLogic {
  private Wallet wallet;
  private TransactionManager transactionManager;
  // Necesitamos manejar conversiones de moneda
  private double exchangeRate;

  /**
   * Crea una instancia de BusinessLogic con la billetera, el administrador de
   * transacciones y la tasa de cambio especificados.
   * 
   * @param wallet             La billetera asociada a la lógica de negocio.
   * @param transactionManager El administrador de transacciones asociado a la
   *                           lógica de negocio.
   * @param exchangeRate       La tasa de cambio utilizada para convertir monedas.
   */
  public BusinessLogic(Wallet wallet, TransactionManager transactionManager, double exchangeRate) {
    this.wallet = wallet;
    this.transactionManager = transactionManager;
    this.exchangeRate = exchangeRate;
  }

  /**
   * Realiza un depósito en la billetera.
   * 
   * @param amount El monto a depositar.
   * @return true si el depósito es exitoso, false si el monto es negativo.
   */
  public boolean performDeposit(double amount) {
    if (!wallet.deposit(amount)) {
      System.out.println("\u001B[31m" + "*******************************************");
      System.out.println("No se pudo depositar CLP " + amount);
      System.out.println("Monto a depositar no puede ser negativo");
      System.out.println("*******************************************" + "\u001B[0m");
      // Retorna false si el monto es negativo
      return false;
    } else {
      System.out.println("Depósito realizado de CLP: " + amount + "\n");
      // Retorno true si el depósito es exitoso
      return true;
    }
  }

  /**
   * Realiza un retiro de la billetera.
   * 
   * @param amount El monto a retirar.
   * @return true si el retiro es exitoso, false si los fondos son insuficientes.
   */
  public boolean performWithdrawal(double amount) {
    if (wallet.withdraw(amount)) {
      System.out.println("Retiro realizado de CLP:  " + amount + "\n");
      // Retorna true si el retiro es exitoso
      return true;
    } else {
      System.out.println("\u001B[31m" + "*******************************************");
      System.out.println("No se pudo retirar CLP " + amount);
      System.out.println("Fondos insuficientes para realizar el retiro.");
      System.out.println("*******************************************" + "\u001B[0m");
      // Retorna false si los fondos son insuficientes
      return false;
    }
  }

  /**
   * Obtiene el saldo actual en CLP.
   * 
   * @return El saldo actual en CLP.8
   */
  public double checkBalanceCLP() {
    return wallet.getBalance(); // Retorna el saldo actual en CLP
  }

  /**
   * Obtiene el saldo actual en USD.
   * 
   * @return El saldo actual en USD.
   */
  public double getBalanceUSD() {
    return convertCurrencyToUSD(checkBalanceCLP()); // Convierte el saldo en CLP a USD
  }

  /**
   * Convierte una cantidad de moneda local a USD.
   * 
   * @param amountInLocalCurrency La cantidad en moneda local a convertir.
   * @return La cantidad convertida a USD.
   */
  public double convertCurrencyToUSD(double amountInLocalCurrency) {
    return amountInLocalCurrency / exchangeRate;
  }
}