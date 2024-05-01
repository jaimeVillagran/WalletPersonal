package transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositTest {
    private Deposit deposit;

    @BeforeEach
    public void setUp() {
        deposit = new Deposit(100.0);
    }

    @Test
    public void depositTypeIsCorrect() {
        assertEquals("Depósito", deposit.getType());
    }

    @Test
    public void depositAmountIsCorrect() {
        assertEquals(100.0, deposit.getAmount());
    }

    @Test
    public void depositDateIsNotNull() {
        LocalDateTime date = deposit.getDate();
        assertTrue(date != null);
    }

    @Test
    public void depositDescriptionIsCorrect() {
        String description = deposit.getDescription();
        assertTrue(description.contains("Depósito"));
        assertTrue(description.contains("100.0"));
    }
}