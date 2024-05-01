package authentication;

import user.User;

import java.util.Scanner;

/**
 * Esta clase representa un Autenticador para una aplicación bancaria.
 * Proporciona métodos para autenticar a un usuario basado en credenciales predefinidas.
 */
public class Authenticator {
  private User predefinedUser;
  private final Scanner sc;

  /**
   * Construye una nueva instancia de Authenticator con una instancia de User y Scanner dadas.
   * @param predefinedUser la instancia de User que se utilizará para la autenticación.
   * @param sc la instancia de Scanner que se utilizará para la entrada del usuario.
   */
  public Authenticator(User predefinedUser, Scanner sc) {
    this.predefinedUser = predefinedUser;
    this.sc = sc;
  }

  /**
   * Autentica a un usuario basado en el nombre de usuario y la contraseña proporcionados.
   * Al usuario se le dan tres intentos para ingresar las credenciales correctas.
   * @param username el nombre de usuario a autenticar.
   * @param password la contraseña a autenticar.
   * @return verdadero si el usuario se autentica con éxito, falso en caso contrario.
   */
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

  /**
   * Establece una nueva instancia de User predefinida.
   * @param predefinedUser la nueva instancia de User a establecer.
   */
  public void setPredefinedUser(User predefinedUser) {
    this.predefinedUser = predefinedUser;
  }

  /**
   * Devuelve la instancia de User predefinida.
   * @return la instancia de User predefinida.
   */
  public User getPredefinedUser() {
    return predefinedUser;
  }
}