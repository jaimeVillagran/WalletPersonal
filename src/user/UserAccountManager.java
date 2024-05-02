package user;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Esta clase representa un Administrador de Cuentas de Usuario para una aplicación bancaria.
 * Proporciona métodos para crear un nuevo usuario.
 */
public class UserAccountManager {
  private final Scanner scanner; // Asegúrate de que esta es la declaración correcta

  /**
   * Construye una nueva instancia de UserAccountManager con una instancia de Scanner dada.
   * @param scanner la instancia de Scanner que se utilizará para la entrada del usuario.
   */
  public UserAccountManager(Scanner scanner) {
    this.scanner = scanner; // Asegúrate de que el parámetro se asigna correctamente a la variable de instancia
  }

  /**
   * Crea un nuevo usuario solicitando al usuario que ingrese su nombre, apellido, correo electrónico y contraseña.
   * @return la nueva instancia de User creada.
   */

  /**
   * Crea un nuevo usuario solicitando al usuario que ingrese su nombre, apellido, correo electrónico y contraseña.
   * @return la nueva instancia de User creada.
   */
  public User createUser() {
    // Color azul para el mensaje de crear una nueva cuenta
    System.out.println("\u001B[34m********************************************************");
    System.out.println("*** Crear una nueva cuenta ***");
    System.out.println("********************************************************\u001B[0m");

    System.out.print("Ingresa tu nombre de usuario: ");
    String firstName = scanner.nextLine().trim();
    System.out.print("Ingresa tu apellido: ");
    String lastName = scanner.nextLine().trim();
    System.out.print("Ingresa tu correo electrónico: ");
    String email = scanner.nextLine().trim();
    System.out.print("Ingresa tu contraseña: ");
    String password = scanner.nextLine().trim();

    // Puedes agregar validaciones adicionales aquí

    // Crear un nuevo objeto User con la información ingresada
    User newUser = new User(firstName, lastName, email, password);
    // Mostrar el mensaje de cuenta creada con éxito en color azul
    System.out.println("\u001B[34m******************************************************");
    System.out.println("Cuenta creada con éxito. ¡Bienvenido, " + firstName + " " + lastName + " !");
    System.out.println("******************************************************\u001B[0m");
    return newUser;
  }
}