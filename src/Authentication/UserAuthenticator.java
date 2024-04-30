package authentication;

import user.User;

import java.util.Scanner;

public class UserAuthenticator {
  private final Scanner scanner;
  private final User predefinedUser;
  private final int maxAttempts;

  public UserAuthenticator(User predefinedUser, Scanner sc, int maxAttempts) {
    this.predefinedUser = predefinedUser;
    this.scanner = sc;
    this.maxAttempts = maxAttempts;
  }

  /**
   * Verifica si las credenciales proporcionadas coinciden con las credenciales
   * almacenadas.
   *
   * @param email    El email proporcionado por el usuario.
   * @param password La contraseña proporcionada por el usuario.
   * @return true si las credenciales coinciden, false de lo contrario.
   */
  private boolean credentialsMatch(String email, String password) {
    return predefinedUser.getEmail().equals(email) && predefinedUser.checkPassword(password);
  }

  /**
   * Obtiene el número máximo de intentos permitidos.
   *
   * @return El número máximo de intentos permitidos.
   */
  public int getMaxAttempts() {
    return maxAttempts;
  }

  /**
   * Autentica al usuario ingresando las credenciales (email y contraseña) hasta
   * un máximo de intentos.
   *
   * @return User si la autenticación es exitosa, null de lo contrario.
   */
  public User authenticate() {
    int attempts = 0;

    while (attempts < maxAttempts) {
      System.out.print("Ingrese su email: ");
      String email = scanner.nextLine().trim();
      System.out.print("Ingrese su contraseña: ");
      String password = scanner.nextLine().trim();

      System.out.println("Intento " + (attempts + 1) + ": email=" + email + ", password=" + password);

      // Verifica si las credenciales coinciden
      if (credentialsMatch(email, password)) {
        // Credenciales válidas: retorna `predefinedUser`
        System.out.println("¡Bienvenido, " + predefinedUser.getFirstName() + " " + predefinedUser.getLastName() + "!");
        return predefinedUser;
      } else {
        attempts++;
        if (attempts >= maxAttempts) {
          // Mensaje informando que se han agotado los intentos y retorno de null
          System.out.println("Se han agotado los intentos. Por favor, vuelva a intentarlo más tarde.");
          return null;
        } else {
          // Mensaje de credenciales incorrectas
          System.out.println("\u001B[31m*****************************************************************");
          System.out.println("** Credenciales incorrectas. Por favor, inténtelo de nuevo. **");
          System.out.println("****************************************************************\u001B[0m");
        }
      }
    }
    // Si se llega al final sin retornar, aseguramos retornar null por defecto
    return null;
  }
}