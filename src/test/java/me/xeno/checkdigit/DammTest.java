package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DammTest {

    @Test
    void calculateCheckDigit() {
        CheckDigitService checkDigit = new Damm();
        assertEquals("4", checkDigit.calculate("572"));
        assertEquals("4", checkDigit.calculate("0572"));
        assertEquals("8", checkDigit.calculate("9114"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        CheckDigitService checkDigit = new Damm();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(""));
        assertThrows(NumberFormatException.class, () -> checkDigit.calculate("572a"));

    }

    @Test
    void isValid() {
        CheckDigitService checkDigit = new Damm();
        assertTrue(checkDigit.isValid("5724"));
        assertFalse(checkDigit.isValid("5720"));
    }

    @Test
    void isValidWithInvalidArgument() {
        CheckDigitService checkDigit = new Damm();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid(""));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid("1"));
    }
}