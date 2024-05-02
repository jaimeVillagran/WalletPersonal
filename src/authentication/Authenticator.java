package authentication;

import user.User;

public interface Authenticator {
    boolean authenticate(String inputEmail, String inputPassword);
}
