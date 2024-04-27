public class EUR implements Currency {
  public double getExchangeRate() {
    return 1000.0; // 1 EUR = 1000 CLP
  }

  public String getCurrencyCode() {
    return "EUR";
  }

  public String getDenomination() {
    return "EUR";
  }

  public String getSymbol() {
    return "€";
  }

}
