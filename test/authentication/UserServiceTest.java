package authentication;

import models.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User service test.
 */
public class UserServiceTest {
        private UserService userService;

        @BeforeEach
        void setUp() {
            userService = new UserService(); // Inicializa con el usuario Jaime por defecto.
        }

       /**
 * Prueba para la autenticación exitosa de un usuario.
 * Este método de prueba verifica la funcionalidad de autenticación cuando se intenta autenticar a un usuario con credenciales válidas.
 *
 * El flujo de la prueba es el siguiente:
 * 1. Se intenta autenticar a un usuario con un correo electrónico y contraseña válidos.
 * 2. Se verifica que el resultado de la autenticación no sea nulo, lo que indica que la autenticación fue exitosa.
 * 3. Se verifica que el nombre del usuario autenticado sea el esperado.
 */
@Test
void testAuthenticateUser_Success() {
    User result = userService.authenticateUser("jaime@gmail.com", "jaime1234");
    assertNotNull(result, "El usuario debe autenticarse correctamente con credenciales válidas.");
    assertEquals("Jaime", result.getFirstName(), "El nombre del usuario debe ser Jaime.");
}

    /**
 * Prueba para la autenticación de un usuario con contraseña incorrecta.
 * Este método de prueba verifica la funcionalidad de autenticación cuando se intenta autenticar a un usuario con una contraseña incorrecta.
 *
 * El flujo de la prueba es el siguiente:
 * 1. Se intenta autenticar a un usuario con un correo electrónico válido pero con una contraseña incorrecta.
 * 2. Se verifica que el resultado de la autenticación sea nulo, lo que indica que la autenticación ha fallado como se esperaba.
 */
@Test
void testAuthenticateUser_Failure_WrongPassword() {
    User result = userService.authenticateUser("jaime@gmail.com", "incorrectPassword");
    assertNull(result, "La autenticación debe fallar si la contraseña es incorrecta.");
}

       /**
 * Prueba para la autenticación de un usuario inexistente.
 * Este método de prueba verifica la funcionalidad de autenticación cuando se intenta autenticar a un usuario que no existe.
 *
 * El flujo de la prueba es el siguiente:
 * 1. Se intenta autenticar a un usuario con un correo electrónico que no está asociado a ningún usuario existente.
 * 2. Se verifica que el resultado de la autenticación sea nulo, lo que indica que la autenticación ha fallado como se esperaba.
 */
@Test
void testAuthenticateUser_Failure_NonExistentUser() {
    User result = userService.authenticateUser("nonexistent@email.com", "password");
    assertNull(result, "La autenticación debe fallar si el usuario no existe.");
}

      /**
 * Prueba para la creación de un nuevo usuario.
 * Este método de prueba verifica la funcionalidad de creación de un nuevo usuario y su posterior autenticación.
 *
 * El flujo de la prueba es el siguiente:
 * 1. Se crea un nuevo usuario con los datos proporcionados.
 * 2. Se verifica que el objeto del nuevo usuario no sea nulo, lo que indica que la creación fue exitosa.
 * 3. Se verifica que el nombre del nuevo usuario sea el esperado.
 * 4. Se autentica al nuevo usuario con las credenciales proporcionadas durante su creación.
 * 5. Se verifica que el objeto del usuario autenticado no sea nulo, lo que indica que la autenticación fue exitosa.
 */
@Test
void testCreateNewUser() {
    // Creación de un nuevo usuario
    User newUser = userService.createNewUser("Ana", "Perez", "ana@gmail.com", "ana1234");

    // Verificación de que el nuevo usuario no es nulo
    assertNotNull(newUser, "Debe crear un nuevo usuario correctamente.");

    // Verificación de que el nombre del nuevo usuario es el esperado
    assertEquals("Ana", newUser.getFirstName(), "El nombre del nuevo usuario debe ser Ana.");

    // Autenticación del nuevo usuario
    User authenticatedUser = userService.authenticateUser("ana@gmail.com", "ana1234");

    // Verificación de que el usuario autenticado no es nulo
    assertNotNull(authenticatedUser, "El nuevo usuario debe poder autenticarse con las credenciales proporcionadas.");
}

    }
