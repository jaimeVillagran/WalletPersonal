import java.util.HashMap;
import java.util.Map;

public class CurrencyManager {
  private Map<String, Currency> currencies;

  public CurrencyManager() {
    this.currencies = new HashMap<>();
  }

  public void addCurrency(Currency currency) {
    currencies.put(currency.getCurrencyCode(), currency);
  }

  public void removeCurrency(String currencyCode) {
    currencies.remove(currencyCode);
  }

  public Currency getCurrency(String currencyCode) {
    return currencies.get(currencyCode);
  }

  public double convertToCLP(double amount, Currency currency) {
    return amount * currency.getExchangeRate();
  }

  public double convertFromCLP(double amountCLP, Currency currency) {
    return amountCLP / currency.getExchangeRate();
  }

  public Map<String, Currency> getAvailableCurrencies() {
    return currencies;
  }

}
