package authentication;

import user.User;

import java.util.Scanner;

public class Authenticator {
  private User predefinedUser;
  private final Scanner sc;

  // Constructor para crear una instancia de Authenticator
  public Authenticator(User predefinedUser, Scanner sc) {
    this.predefinedUser = predefinedUser;
    this.sc = sc;;
  }

  // Método para autenticar al usuario
  public boolean authenticate(String username, String password) {
    int attempts = 0;
    while (attempts < 3) {
      System.out.print("Ingrese su email: ");
      String inputEmail = sc.nextLine().trim();
      System.out.print("Ingrese su contraseña: ");
      String inputPassword = sc.nextLine().trim();

      // Verificar las credenciales proporcionadas
      if (predefinedUser.getEmail().equals(inputEmail) && predefinedUser.checkPassword(inputPassword)) {
        System.out.println(
                "¡Bienvenido, " + predefinedUser.getFirstName() + " " + predefinedUser.getLastName() + "!");
        return true;
      } else {
        attempts++;
        if (attempts < 3) {
          System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
      }
    }
    System.out.println("******************************************************************************");
    System.out.println("* Se han agotado los intentos. Por favor, vuelva a intentarlo más tarde. *");
    System.out.println("******************************************************************************");
    return false;
  }

  // Setter para cambiar el usuario predefinido si es necesario
  public void setPredefinedUser(User predefinedUser) {

    this.predefinedUser = predefinedUser;
  }

  // Getter para obtener el usuario predefinido
  public User getPredefinedUser() {
    return predefinedUser;
  }
}