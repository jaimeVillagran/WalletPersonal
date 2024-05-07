package authentication;

import java.util.ArrayList;
import java.util.List;

import user.User;

/**
 * La clase UserService es responsable de administrar la autenticación y
 * creación de usuarios.
 */
public class UserService {

  private List<User> users;

  /**
   * Crea una instancia de UserService e inicializa la lista de usuarios con un
   * usuario de ejemplo.
   */
  public UserService() {
    this.users = new ArrayList<>();
    this.users.add(new User("Jaime", "Villagran", "jaime@gmail.com", "jaime1234"));
  }

  /**
   * Autentica a un usuario utilizando el correo electrónico y la contraseña
   * proporcionados.
   * 
   * @param email    el correo electrónico del usuario
   * @param password la contraseña del usuario
   * @return el objeto User correspondiente si la autenticación es exitosa, o null
   *         si no se encuentra un usuario válido
   */
  @Override
  public User authenticateUser(String email, String password) {
    return users.stream()
        .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
        .findFirst()
        .orElse(null);
  }

  /**
   * Crea un nuevo usuario con los datos proporcionados y lo agrega a la lista de
   * usuarios.
   * 
   * @param firstName el nombre del usuario
   * @param lastName  el apellido del usuario
   * @param email     el correo electrónico del usuario
   * @param password  la contraseña del usuario
   * @return el objeto User recién creado
   */
  @Override
  public User createNewUser(String firstName, String lastName, String email, String password) {
    User newUser = new User(firstName, lastName, email, password);
    users.add(newUser);
    return newUser;
  }

}
