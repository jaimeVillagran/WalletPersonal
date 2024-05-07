package authentication;

import java.util.ArrayList;
import java.util.List;

import user.User;

public class UserService {

  private List<User> users;

  public UserService() {
    this.users = new ArrayList<>();
    this.users.add(new User("Jaime", "Villagran", "jaime@gmail.com", "jaime1234"));
  }

  @Override
  public User authenticateUser(String email, String password) {
    return users.stream()
        .filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password))
        .findFirst()
        .orElse(null);
  }

  @Override
  public User createNewUser(String firstName, String lastName, String email, String password) {
    User newUser = new User(firstName, lastName, email, password);
    users.add(newUser);
    return newUser;
  }

}
