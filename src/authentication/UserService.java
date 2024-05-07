package authentication;

import models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase UserService implementa la interfaz IUserService y proporciona una
 * implementación concreta
 * de los métodos para autenticar a un usuario y crear un nuevo usuario.
 *
 * Esta clase mantiene una lista de usuarios para simular una base de datos de
 * usuarios.
 */
public class UserService implements IUserService {
  // Lista de usuarios
  private final List<User> users;

  /**
   * Constructor de UserService.
   * Inicializa la lista de usuarios y agrega un usuario predeterminado a la
   * lista.
   */
  public UserService() {
    this.users = new ArrayList<>();
    this.users.add(new User("Jaime", "Villagran", "jaime@gmail.com", "jaime1234"));
  }

  /**
   * Autentica a un usuario.
   * Este método toma un correo electrónico y una contraseña, y devuelve un objeto
   * User si la autenticación es exitosa.
   * Si la autenticación falla, este método devuelve null.
   *
   * @param email    el correo electrónico del usuario
   * @param password la contraseña del usuario
   * @return un objeto User si la autenticación es exitosa, null en caso contrario
   */
  @Override
  public User authenticateUser(String email, String password) {
    return users.stream()
        .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
        .findFirst()
        .orElse(null);
  }

  /**
   * Crea un nuevo usuario.
   * Este método toma un nombre, un apellido, un correo electrónico y una
   * contraseña, y devuelve un objeto User si la creación es exitosa.
   * El nuevo usuario se agrega a la lista de usuarios.
   *
   * @param firstName el nombre del usuario
   * @param lastName  el apellido del usuario
   * @param email     el correo electrónico del usuario
   * @param password  la contraseña del usuario
   * @return un objeto User si la creación es exitosa
   */
  @Override
  public User createNewUser(String firstName, String lastName, String email, String password) {
    User newUser = new User(firstName, lastName, email, password);
    users.add(newUser);
    return newUser;
  }
}