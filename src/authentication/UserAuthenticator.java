package authentication;

import user.User;

public class UserAuthenticator implements Authenticator {
  private User predefinedUser;

  public UserAuthenticator(User predefinedUser) {
    this.predefinedUser = predefinedUser;
  }

  @Override
  public boolean authenticate(String inputEmail, String inputPassword) {
    if (predefinedUser.getEmail().equals(inputEmail) && predefinedUser.checkPassword(inputPassword)) {
      System.out.println("¡Bienvenido, " + predefinedUser.getFirstName() + " " + predefinedUser.getLastName() + "!");
      return true;
    } else {
      System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
      return false;
    }
  }
}