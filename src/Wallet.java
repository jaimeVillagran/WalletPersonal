
public abstract class Wallet {
  protected double balanceCLP; // Saldo en pesos chilenos (CLP)
  protected CurrencyManager currencyManager; // Manejo de monedas

  public Wallet(CurrencyManager currencyManager) {
    this.balanceCLP = 0;
    this.currencyManager = currencyManager;
  }

  public abstract void deposit(double amount); // Método abstracto para depósito en CLP

  public abstract void withdraw(double amount); // Método abstracto para retiro en CLP

  public double getBalance() {
    return balanceCLP; // Devuelve el saldo en CLP
  }

  public void checkBalance(Currency currency) {
    // Convierte el saldo a la moneda deseada
    double convertedBalance = currencyManager.convertFromCLP(balanceCLP, currency);
    System.out.println(
        "Saldo actual en " + currency.getCurrencyCode() + ": " + currency.getSymbol() + " " + convertedBalance);
  }
}