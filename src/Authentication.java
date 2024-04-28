import java.util.Scanner;

public class Authentication {
  private User predefinedUser;
  private Scanner sc;

  public Authentication() {
    this.sc = new Scanner(System.in);
    this.predefinedUser = new User("Jaime", "jaime1234");
    ;
  }

  public boolean authenticate() {
    int attempts = 0;
    while (attempts < 3) {
      System.out.println("=================");
      System.out.println("Ingrese su nombre de usuario:");
      String inputName = sc.nextLine();
      System.out.println("Ingrese su contraseña:");
      String inputPassword = sc.nextLine();

      if (predefinedUser.getName().equals(inputName) && predefinedUser.checkPassword(inputPassword)) {
        System.out.println("¡Bienvenido, " + predefinedUser.getName() + "!");
        return true;
      } else {
        attempts++;
        if (attempts < 3) {
          System.out.println("Nombre de usuario o contraseña incorrectos. Intento " + attempts + " de 3.");
        }
      }
    }
    System.out.println("Se han agotado los intentos. Por favor, vuelva a intentarlo más tarde.");
    return false;
  }

  public void closeScanner() {
    sc.close();
  }

  public User getPredefinedUser() {
    return predefinedUser;
  }
}