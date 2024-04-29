package Authentication;

import java.util.Scanner;

import User.User;

public class Authenticator {
  private User predefinedUser;
  private Scanner sc;

  // Constructor para crear una instancia de Authenticator
  public Authenticator(User predefinedUser) {
    this.sc = new Scanner(System.in);
    this.predefinedUser = new User(System.in);
  }

  // Método para autenticar al usuario

  public boolean authenticate() {
    int attempts = 0;
    while (attempts < 3) {
      System.out.println("Ingrese su email:");
      String inputEmail = sc.nextLine();
      System.out.println("Ingrese su contraseña:");
      String inputPassword = sc.nextLine();

      // Verificar las credenciales proporcionadas
      if (predefinedUser.getEmail().equals(inputEmail) && predefinedUser.checkPassword(inputPassword)) {
        System.out.println("¡Bienvenido, " + predefinedUser.getFirstName() + " " + predefinedUser.getLastName() + "!");
        return true;

      } else {
        attempts++;
        if (attempts < 3) {
          System.out.println("*********************************************************");
          System.out.println("* Las credenciales son incorrectas. Intente nuevamente. *");
          System.out.println("*********************************************************");
        }
      }

      System.out.println("******************************************************************************");
      System.out.println("* Se han agotado los intentos. Por favor, vuelva a intentarlo más tarde. *");
      System.out.println("******************************************************************************");
      return false;
    }

  // Cerrar el objeto Scanner
  public void closeScanner() {
    sc.close();
  }

  // Setter para cambiar el usuario predefinido si es necesario
  public void setPredefinedUser(User newPredefinedUser) {
    this.predefinedUser = newPredefinedUser;
  }

  // Getter para obtener el usuario predefinido
  public User getPredefinedUser() {
    return predefinedUser;
  }

  // Getter para obtener el objeto Scanner
  public Scanner getScanner() {
    return sc;
  }
}