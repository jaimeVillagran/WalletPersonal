package App;

import authentication.*;
import models.Wallet;
import transactions.*;
import menu.Menu;

/**
 * La clase Main es la clase principal que contiene el método main para iniciar
 * la aplicación WalletPersonal.
 * 
 * La aplicación WalletPersonal permite a los usuarios realizar transacciones y
 * administrar su saldo en una billetera virtual.
 * 
 * Para iniciar la aplicación, se crea una instancia de Wallet con un saldo
 * inicial de 0.0. Luego se crean instancias de UserService y
 * TransactionService, que son implementaciones concretas de IUserService e
 * ITransactionService respectivamente.
 * 
 * A continuación, se crea una instancia de Menu con System.in y System.out para
 * la entrada y salida estándar. El menú proporciona opciones para que los
 * usuarios interactúen con la aplicación.
 * 
 * El método initialMenu() se llama para mostrar el menú inicial y comenzar la
 * ejecución de la aplicación.
 */
public class Main {

  /**
   * Método principal que inicia la aplicación.
   * Crea una instancia de Wallet y la inicializa con un saldo de 0.0.
   * Crea instancias de UserService y TransactionService.
   * Crea una instancia de Menu y le pasa las instancias de UserService,
   * TransactionService, System.in y System.out.
   * Llama al método initialMenu() de la instancia de Menu para iniciar el menú
   * principal.
   *
   * @param args los argumentos de la línea de comandos
   */
  public static void main(String[] args) {
    Wallet wallet = new Wallet(0.0);

    IUserService userService = new UserService();
    ITransactionService transactionService = new TransactionService(wallet);

    Menu menu = new Menu(userService, transactionService, System.in, System.out);

    menu.initialMenu();
  }
}