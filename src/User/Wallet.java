package User;

/**
 * La clase Wallet representa una billetera que contiene un saldo.
 */
public class Wallet {
  private double balance;

  /**
   * Construye una billetera con el saldo inicial especificado.
   *
   * @param initialBalance el saldo inicial de la billetera
   */
  public Wallet(double initialBalance) {
    this.balance = initialBalance;
  }

  /**
   * Devuelve el saldo actual de la billetera.
   *
   * @return el saldo actual de la billetera
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Establece el saldo de la billetera al valor especificado.
   *
   * @param balance el nuevo saldo de la billetera
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }

  /**
   * Muestra el saldo actual de la billetera.
   */
  public void checkBalance() {
    System.out.println("********************************");
    System.out.println("Saldo actual: CLP " + String.format("%.2f", balance));
    System.out.println("********************************");
  }

  /**
   * Deposita la cantidad especificada de dinero en la billetera.
   *
   * @param amount la cantidad de dinero a depositar
   */
  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Depósito exitoso con éxito. Nuevo saldo: CLP" + String.format("%.2f", balance));
    } else {
      System.out.println("El monto a depositar debe ser mayor a cero");
    }
  }

  /**
   * Retira la cantidad especificada del saldo de la billetera.
   * 
   * @param amount la cantidad a retirar
   */
  public void withdraw(double amount) {
    if (amount > 0 && balance >= amount) {
      balance -= amount;
      System.out.println("Retiro realizado con éxito. Nuevo saldo: CLP " + String.format("%.2f", balance));
    } else if (amount <= 0) {
      System.out.println("El monto a retirar debe ser mayor que cero.");
    } else {
      System.out.println("No hay saldo suficiente para realizar el retiro.");
    }
  }
}