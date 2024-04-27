public class ChileanWallet extends Wallet {
  public ChileanWallet(CurrencyManager currencyManager) {
    super(currencyManager);
  }

  @Override
  public void deposit(double amount) {
    if (amount <= 0) {
      System.out.println("Error: El monto a depositar debe ser mayor que cero.");
      return;
    }
    balanceCLP += amount;
    System.out.println("Depósito realizado: CLP " + amount);
    System.out.println("Nuevo saldo: CLP " + balanceCLP);
  }

  @Override
  public void withdraw(double amount) {
    if (amount <= 0) {
      System.out.println("Error: El monto a retirar debe ser mayor que cero.");
      return;
    }
    if (balanceCLP < amount) {
      System.out.println("Error: Fondos insuficientes.");
      return;
    }
    balanceCLP -= amount;
    System.out.println("Retiro realizado: CLP " + amount);
    System.out.println("Nuevo saldo: CLP " + balanceCLP);
  }

}
