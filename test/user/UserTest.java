package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("John", "Doe", "john.doe@example.com", "password123");
    }

    @Test
    public void correctFirstNameIsReturned() {
        assertEquals("John", user.getFirstName());
    }

    @Test
    public void correctLastNameIsReturned() {
        assertEquals("Doe", user.getLastName());
    }

    @Test
    public void correctEmailIsReturned() {
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void correctPasswordIsReturned() {
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void passwordIsVerifiedCorrectly() {
        assertTrue(user.checkPassword("password123"));
    }

    @Test
    public void walletIsNotNullAfterInitialization() {
        assertTrue(user.getWallet() != null);
    }
}
