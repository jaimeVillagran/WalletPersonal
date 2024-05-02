package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class UserAccountManagerTest {
    private UserAccountManager manager;

    @BeforeEach
    public void setUp() {
        // Simula la entrada del usuario
        String data = "John\nDoe\njohndoe@example.com\npassword123\n";
        InputStream stdin = new ByteArrayInputStream(data.getBytes());
        manager = new UserAccountManager(stdin);
    }

    @Test
    public void testCreateUser() {
        User user = manager.createUser();
        assertNotNull(user, "El usuario no debería ser nulo");
        assertEquals("John", user.getFirstName(), "El nombre debe coincidir con la entrada proporcionada");
        assertEquals("Doe", user.getLastName(), "El apellido debe coincidir con la entrada proporcionada");
        assertEquals("johndoe@example.com", user.getEmail(), "El correo electrónico debe coincidir con la entrada proporcionada");
        assertEquals("password123", user.getPassword(), "La contraseña debe coincidir con la entrada proporcionada");
    }
}