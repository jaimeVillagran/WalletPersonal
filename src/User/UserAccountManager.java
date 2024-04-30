package user;

import java.util.Scanner;

public class UserAccountManager {
  private final Scanner scanner;

  public UserAccountManager(Scanner scanner) {
    this.scanner = scanner;
  }

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
