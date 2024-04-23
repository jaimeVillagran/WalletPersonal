public class OperationsMenu {
  private User user;
  private Wallet wallet;
  private CurrencyManager currencyManager;
  private Scanner scanner;

  public OperationsMenu(User user, Wallet wallet, CurrencyManager currencyManager, Scanner scanner) {
    this.user = user;
    this.wallet = wallet;
    this.currencyManager = currencyManager;
    this.scanner = scanner;
  }

  public void showMenu() {
    while (true) {
      System.out.println("\nElija una operación:");
      System.out.println("1. Depositar en CLP");
      System.out.println("2. Retirar en CLP");
      System.out.println("3. Consultar saldo en moneda específica");
      System.out.println("4. Salir");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Limpiar el búfer de entrada

      switch (choice) {
        case 1:
          System.out.print("Ingrese el monto a depositar en CLP: ");
          double amountDeposit = scanner.nextDouble();
          wallet.deposit(amountDeposit);
          break;

        case 2:
          System.out.print("Ingrese el monto a retirar en CLP: ");
          double amountWithdraw = scanner.nextDouble();
          wallet.withdraw(amountWithdraw);
          break;

        case 3:
          System.out.println("Monedas disponibles:");
          for (String currencyCode : currencyManager.getAvailableCurrencies().keySet()) {
            System.out.println(currencyCode);
          }
          System.out.print("Seleccione la moneda para consultar el saldo: ");
          String currencyCode = scanner.next();
          Currency currency = currencyManager.getCurrency(currencyCode);
          wallet.checkBalance(currency);
          break;

        case 4:
          System.out.println("Saliendo del programa...");
          return;

        default:
          System.out.println("Opción no válida.");
          break;
      }
    }
  }
}