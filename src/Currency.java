public enum Currency {

  // Enumeración de las monedas
  EUR("Euro", "EUR", "€"),
  CLP("Peso Chile", "CLP", "$"),
  GBP("Libra esterlina", "GBP", "£"),
  USD("Dólar estadounidense", "USD", "USD$");

  private final String name;
  private final String denomination;
  private final String symbol;

  // Constructor
  Currency(String name, String denomination, String symbol) {
    this.name = name;
    this.denomination = denomination;
    this.symbol = symbol;
  }

  // Métodos para obtener la información de la moneda
  public String getName() {
    return name;
  }

  public String getDenomination() {
    return denomination;
  }

  public String getSymbol() {
    return symbol;
  }
}
