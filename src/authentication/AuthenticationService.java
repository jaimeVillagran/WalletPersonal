package authentication;

import user.UserAccountManager;

import java.util.Scanner;

public class AuthenticationService {
  private Authenticator authenticator;
  private UserAccountManager userAccountManager;
  private Scanner sc;

  public AuthenticationService(Authenticator authenticator, Scanner sc, UserAccountManager userAccountManager) {
    this.authenticator = authenticator;
    this.sc = sc;
    this.userAccountManager = userAccountManager;

  }

  public void authenticateUser() {
    int attempts = 0;
    while (attempts < 3) {
      System.out.print("Ingrese su email: ");
      String inputEmail = sc.nextLine().trim();
      System.out.print("Ingrese su contraseña: ");
      String inputPassword = sc.nextLine().trim();

      if (authenticator.authenticate(inputEmail, inputPassword)) {
        System.out.println("Autenticación exitosa.");
        return;
      } else {
        System.out.println("\u001B[31m" + "*******************************"); // ANSI red
        System.out.println("Datos ingresados incorrectos");
        System.out.println("*******************************" + "\u001B[0m"); // Reset ANSI
        attempts++;
      }

    }
    System.out.println("\u001B[31m" + "*****************************************");
    System.out.println("No se puede ingresar, intente más tarde");
    System.out.println("*****************************************" + "\u001B[0m");
    System.exit(0); // Terminar la ejecución del programa
  }

  public void createAccount() {
    System.out.println("Creando una nueva cuenta de usuario...");
    userAccountManager.createUser();
  }
}
