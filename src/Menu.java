public class Menu {
  private User user;
  private String sc;

  // Constructor
  public Menu(User user, String sc) {
    this.user = user;
    this.sc = sc;
  }

  // Add this closing brace to complete the class body

  // Metodos
  public void display() {
    // Seleccion de moneda
    Currency chosenCurrency = selectCurrency();

    // Crear una cuenta Wallet con la moneda seleccionada y el usuario actual.
    Wallet wallet = new Wallet(user, chosenCurrency);
    user.addAccount(wallet);

    while (true) {
      System.out.println("\nMenú:");
      System.out.println("1. Depositar");
      System.out.println("2. Retirar");
      System.out.println("3. Consultar saldo");
      System.out.println("4. Salir");
      System.out.print("Seleccione una opción: ");
      int option = sc.nextInt();
      sc.nextLine(); // Limpiar el búfer de entrada

      switch (option) {
        case 1:
          // Operación de depósito
          System.out.print("Ingrese monto a depositar: ");
          double depositAmount = sc.nextDouble();
          wallet.deposit(depositAmount);
          System.out.println("Depósito realizado.");
          break;

        case 2:
          // Operación de retiro
          System.out.print("Ingrese monto a retirar: ");
          double withdrawAmount = sc.nextDouble();
          boolean success = wallet.withdraw(withdrawAmount);
          if (success) {
            System.out.println("Retiro realizado.");
          } else {
            System.out.println("Fondos insuficientes.");
          }
          break;

        case 3:
          // Operación de consulta de saldo
          System.out.println("Elija cómo desea ver su saldo:");
          System.out.println("1. Moneda predeterminada (" + chosenCurrency.getSymbol() + ")");
          System.out.println("2. Dólares estadounidenses (USD$)");
          System.out.println("3. Euros (EUR)");
          System.out.println("4. Libras esterlinas (GBP)");
          System.out.print("Seleccione una opción: ");
          int currencyOption = sc.nextInt();

          // Consultar saldo y convertir si es necesario
          double balanceInPredeterminedCurrency = wallet.getBalance();
          double convertedBalance;

          switch (currencyOption) {
            case 1:
              // Mostrar saldo en moneda predeterminada
              System.out.println("Saldo actual: " + balanceInPredeterminedCurrency + chosenCurrency.getSymbol());
              break;
            case 2:
              // Convertir saldo a USD$ y mostrar
              convertedBalance = balanceInPredeterminedCurrency / chosenCurrency.getExchangeRate();
              System.out.println("Saldo actual: " + String.format("%.2f", convertedBalance) + " USD$");
              break;
            case 3:
              // Convertir saldo a EUR y mostrar
              convertedBalance = balanceInPredeterminedCurrency / chosenCurrency.getExchangeRate();
              System.out.println("Saldo actual: " + String.format("%.2f", convertedBalance) + " EUR");
              break;
            case 4:
              // Convertir saldo a GBP y mostrar
              convertedBalance = balanceInPredeterminedCurrency / chosenCurrency.getExchangeRate();
              System.out.println("Saldo actual: " + String.format("%.2f", convertedBalance) + " GBP");
              break;

          }

      }
    }
  }

  private Currency selectCurrency() {
    System.out.println("Seleccione una moneda para su cuenta:");
    System.out.println("1. Peso chileno (CLP)");
    System.out.println("2. Dólar estadounidense (USD)");
    System.out.println("3. Euro (EUR)");
    System.out.println("4. Libra esterlina (GBP)");
    System.out.print("Seleccione una opción: ");
    int currencyOption = sc.nextInt();
    sc.nextLine(); // Limpiar el búfer de entrada

    switch (currencyOption) {
      case 1:
        return Currency.CLP;
      case 2:
        return Currency.USD;
      case 3:
        return Currency.EUR;
      case 4:
        return Currency.GBP;
      default:
        System.out.println("Opción inválida. Seleccionando moneda predeterminada (CLP).");
        return Currency.CLP;
    }
  }
}
