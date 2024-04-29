package menu;

import java.util.Scanner;

import Authentication.Authenticator;
import User.User;

public class UserInteraction {

  private Scanner sc;
  private User user;

  public UserInteraction(Scanner sc) {
    this.sc = sc;
  }

  // Método para obtener un objeto User según la elección del usuario

  public User getUser() {

    System.out.println("Tienes una cuenta activa o desea crear una?");
        System.out.println("* Opcion 1 - Cuenta activa");
        System.out.println("* Opcion 2 - Crear cuenta");
        System.out.println("**********************************************");
        System.out.print("Elige uan opción (1/2): ");

        String choice = sc.nextLine().trim();

        if (choice.equals("1")) {
          //Usar cuenta activa
          User predefinesUser = new User();
          "Jaime",
          "Villagran",
          "jaime@gmail.com",
          "jaime12345";
          Authenticator auth = new Authenticator(predefinesUser);

          //Usar cuenta activa
          boolean authenticated = auth.authenticate();

          if (authenticated) {
            return predefinesUser;
          } else {
            System.out.println("Autenticación fallida. Cerrando la aplicación.");
            auth.closeScanner();
            return null;
          }
        } else if (choice.equals("2")) {
          // Crear cuenta
          System.out.println("****** Crear una nueva cuenta **********");

          System.out.print("Ingresa tu nombre: ");
          String firstName = sc.nextLine().trim();

          System.out.print("Ingresa tu apellido: ");
          String lastName = sc.nextLine().trim();

          System.out.print("Ingresa tu correo: ");
          String email = sc.nextLine().trim();

          System.out.print("Ingresa tu contraseña: ");
          String password = sc.nextLine().trim();

          //Crea un nuevo objeto User con la informacion ingresada
          user = new User(firstName, lastName, email, password);
          System.out.println(" * Cuenta creada con éxito. * \n" + "----------------------------------------");
            // Mostrar bienvenida después de crear una nueva cuenta
            System.out.println("**********************************************");
            System.out.println("* ¡Bienvenido, " + firstName + " " + lastName + "! *");
            System.out.println("**********************************************");
            return newUser;
        } else {
            System.out.println("**********************************************");
            System.out.println("* Opción inválida. Por favor, intenta de nuevo. *");
            System.out.println("**********************************************");
            return getUser();  // Volver a pedir al usuario que elija una opción

        }
    }

}
