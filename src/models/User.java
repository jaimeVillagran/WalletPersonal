package models;

/**
 * La clase User representa a un usuario en el sistema.
 * Contiene información como el nombre, apellido, correo electrónico, contraseña
 * y billetera del usuario.
 */
public class User {

  // Nombre del usuario
  private String firstName;

  // Apellido del usuario
  private String lastName;

  // Correo electrónico del usuario
  private String email;

  // Contraseña del usuario
  private String password;

  // Billetera del usuario
  private Wallet wallet;

  /**
   * Constructor de User.
   * Inicializa el nombre, apellido, correo electrónico y contraseña del usuario.
   * También inicializa la billetera del usuario con un saldo de 0.
   *
   * @param firstName el nombre del usuario
   * @param lastName  el apellido del usuario
   * @param email     el correo electrónico del usuario
   * @param password  la contraseña del usuario
   */
  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.wallet = new Wallet(0);
  }

  /**
   * Devuelve el nombre del usuario.
   * 
   * @return el nombre del usuario
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Obtiene el apellido del usuario.
   * 
   * @return el apellido del usuario
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Devuelve el correo electrónico del usuario.
   * 
   * @return el correo electrónico del usuario
   */
  public String getEmail() {
    return email;
  }

  /**
   * Devuelve la contraseña del usuario.
   * 
   * @return la contraseña del usuario.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Obtiene la billetera del usuario.
   * 
   * @return la billetera del usuario.
   */
  public Wallet getWallet() {
    return wallet;
  }

  /**
   * Comprueba si la contraseña proporcionada coincide con la contraseña del
   * usuario.
   * 
   * @param password La contraseña a comprobar.
   * @return true si la contraseña coincide, false en caso contrario.
   */
  public boolean checkPassword(String password) {
    return this.password.equals(password);
  }

}
