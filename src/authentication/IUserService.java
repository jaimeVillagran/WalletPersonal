package authentication;

public interface IUserService {

  User authenticateUser(String email, String password);

  User createNewUser(String firstName, String lastName, String email, String password);

}