public class USD implements Currency {
  public double getExchangeRate() {
    return 900.0; // 1 USD = 900 CLP
  }

  public String getCurrencyCode() {
    return "USD";
  }

  public String getDenomination() {
    return "USD";
  }

  public String getSymbol() {
    return "USD$";
  }

}
