import java.util.Scanner;

public class Authentication {
  private User user;
  private Scanner sc;

  public Authentication(User user, Scanner sc) {
    this.user = user;
    this.sc = sc;
  }

  public boolean authenticate() {
    System.out.println("Ingrese la contraseña del usuario:");
    String password = sc.nextLine();
    if (user.authenticate(password)) {
      System.out.println("Inicio de sesión exitoso");
      return true;
    } else {
      System.out.println("Contraseña incorrecta. Acceso denegado.");
      return false;
    }
  }
}