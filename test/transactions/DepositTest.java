package transactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositTest {
    private Deposit deposit;
    private LocalDateTime now;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy 'a las' HH:mm");


    @BeforeEach
    public void setUp() {
        now = LocalDateTime.now();
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
        // Aquí utilizamos la fecha del depósito para mantener la coherencia.
        String expectedDate = deposit.getDate().format(formatter);
        String expectedDescription = String.format("Depósito of CLP 100.00 on %s", expectedDate);
        assertEquals(expectedDescription, deposit.getDescription());
    }

}