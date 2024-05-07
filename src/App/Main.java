package App;

import menu.Menu;
import user.Wallet;

public class Main {

  public static void main(String[] args) {
    Wallet wallet = new Wallet(0.0); // Asumiendo que Wallet tiene un constructor que acepta un saldo inicial
    // Suponiendo que tienes implementaciones concretas de IUserService y
    // ITransactionService
    IUserService userService = new UserService();
    ITransactionService transactionService = new TransactionService(wallet);

    // Crear una instancia de Menu con System.in y System.out para entrada y salida
    // estándar
    Menu menu = new Menu(userService, transactionService, System.in, System.out);

    // Llamada al método inicial o cualquier otro método necesario para iniciar la
    // aplicación
    menu.initialMenu();
  }

}
