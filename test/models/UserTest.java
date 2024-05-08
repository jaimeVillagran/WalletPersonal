package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Clase de prueba para el modelo de Usuario.
 * Esta clase contiene métodos de prueba para verificar la funcionalidad del modelo de Usuario.
 */
public class UserTest {

    /**
     * Prueba para la creación de un usuario.
     * Este método de prueba verifica la funcionalidad de creación de un usuario y la inicialización de su cartera.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se crea un nuevo usuario con los datos proporcionados.
     * 2. Se verifica que el nombre del nuevo usuario sea el esperado.
     * 3. Se verifica que el apellido del nuevo usuario sea el esperado.
     * 4. Se verifica que el correo electrónico del nuevo usuario sea el esperado.
     * 5. Se verifica que la contraseña del nuevo usuario sea la esperada.
     * 6. Se verifica que la cartera del nuevo usuario no sea nula, lo que indica que se ha inicializado correctamente.
     */
    @Test
    void testUserCreation() {
        User user = new User("John", "Doe", "john.doe@example.com", "securePassword123");
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("securePassword123", user.getPassword());
        assertNotNull(user.getWallet());
    }

    /**
     * Prueba para la verificación de la contraseña de un usuario.
     * Este método de prueba verifica la funcionalidad de verificación de la contraseña de un usuario.
     *
     * El flujo de la prueba es el siguiente:
     * 1. Se crea un nuevo usuario con los datos proporcionados.
     * 2. Se verifica que la contraseña del usuario sea la esperada.
     * 3. Se verifica que la contraseña incorrecta no sea aceptada.
     */
    @Test
    void testPasswordCheck() {
        User user = new User("John", "Doe", "john.doe@example.com", "securePassword123");
        assertTrue(user.checkPassword("securePassword123"));
        assertFalse(user.checkPassword("incorrectPassword"));
    }
}
