package authentication;

import models.User;

/**
 * Interfaz para el servicio de usuario.
 * Esta interfaz define los métodos que deben ser implementados por cualquier
 * clase que proporcione un servicio de usuario.
 * Los métodos incluyen la autenticación de un usuario y la creación de un nuevo
 * usuario.
 */
public interface IUserService {

  /**
   * Autentica a un usuario.
   * Este método toma un correo electrónico y una contraseña, y devuelve un objeto
   * User si la autenticación es exitosa.
   * Si la autenticación falla, este método puede devolver null o lanzar una
   * excepción, dependiendo de la implementación.
   *
   * @param email    el correo electrónico del usuario
   * @param password la contraseña del usuario
   * @return un objeto User si la autenticación es exitosa, null o una excepción
   *         en caso contrario
   */
  User authenticateUser(String email, String password);

  /**
   * Crea un nuevo usuario.
   * Este método toma un nombre, un apellido, un correo electrónico y una
   * contraseña, y devuelve un objeto User si la creación es exitosa.
   * Si la creación falla, este método puede devolver null o lanzar una excepción,
   * dependiendo de la implementación.
   *
   * @param firstName el nombre del usuario
   * @param lastName  el apellido del usuario
   * @param email     el correo electrónico del usuario
   * @param password  la contraseña del usuario
   * @return un objeto User si la creación es exitosa, null o una excepción en
   *         caso contrario
   */
  User createNewUser(String firstName, String lastName, String email, String password);
}