package user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserAccountManagerTest {
    private UserAccountManager userAccountManager;

    @BeforeEach
    public void setUp() {
        userAccountManager = new UserAccountManager();
    }

    @Test
    public void newUserAccountIsCreated() {
        User user = userAccountManager.createUser("John", "Doe", "john.doe@example.com", "password123");
        assertNotNull(user);
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void existingUserAccountIsRetrieved() {
        User user = userAccountManager.createUser("John", "Doe", "john.doe@example.com", "password123");
        User retrievedUser = userAccountManager.getUser("john.doe@example.com");
        assertEquals(user, retrievedUser);
    }
}
