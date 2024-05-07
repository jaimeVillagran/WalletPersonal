package authentication;

/**
 * Esta interfaz define los métodos para autenticar y crear nuevos usuarios.
 */
public interface IUserService {

  /**
   * Autentica a un usuario utilizando su correo electrónico y contraseña.
   *
   * @param email    el correo electrónico del usuario
   * @param password la contraseña del usuario
   * @return el objeto User si la autenticación es exitosa, o null si no lo es
   */
  User authenticateUser(String email, String password);

  /**
   * Crea un nuevo usuario con los datos proporcionados.
   *
   * @param firstName el nombre del usuario
   * @param lastName  el apellido del usuario
   * @param email     el correo electrónico del usuario
   * @param password  la contraseña del usuario
   * @return el objeto User creado
   */
  User createNewUser(String firstName, String lastName, String email, String password);

}