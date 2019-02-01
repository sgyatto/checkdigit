package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DammTest {

    @Test
    void calculateCheckDigit() {
        CheckDigitService checkDigit = new Damm();
        assertEquals("4", checkDigit.calculate("572"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        CheckDigitService checkDigit = new Damm();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(""));
    }
}