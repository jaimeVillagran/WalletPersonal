package authentication;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.User;

public class AuthenticatorTest {
    private Authenticator authenticator;
    private User predefinedUser;

    @BeforeEach
    void setUp() {
        // Configuramos un usuario predefinido para las pruebas
        predefinedUser = new User("user@example.com", "UserFirstName", "UserLastName", "password123");
        authenticator = new Authenticator(predefinedUser);
    }

    @Test
    void testAuthenticateSuccess() {
        // Prueba de autenticación exitosa
        boolean result = authenticator.authenticate(predefinedUser.getEmail(), "password123");
        assertTrue(result, "La autenticación debería ser exitosa con las credenciales correctas.");
    }

    @Test
    void testAuthenticateFailureDueToIncorrectPassword() {
        // Prueba de autenticación fallida por contraseña incorrecta
        boolean result = authenticator.authenticate(predefinedUser.getEmail(), "incorrectPassword");
        assertFalse(result, "La autenticación debería fallar con una contraseña incorrecta.");
    }

    @Test
    void testAuthenticateFailureDueToIncorrectEmail() {
        // Prueba de autenticación fallida por email incorrecto
        boolean result = authenticator.authenticate("wrong@example.com", "password123");
        assertFalse(result, "La autenticación debería fallar con un email incorrecto.");
    }
}

