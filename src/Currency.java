public interface Currency {
  double getExchangeRate(); // Obtiene el tipo de cambio a CLP

  String getCurrencyCode(); // Obtiene el código de la moneda (USD, EUR, GBP, CLP)

  String getDenomination(); // Obtiene la denominación de la moneda (USD, EUR, GBP, CLP)

  String getSymbol(); // Obtiene el símbolo de la moneda ($, €, £, USD$)

}
