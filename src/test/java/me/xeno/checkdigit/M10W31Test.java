package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class M10W31Test {

    @Test
    void calculateCheckDigit() {
        CheckDigitService checkDigit = new M10W31();
        assertEquals("8", checkDigit.calculate("4"));
        assertEquals("1", checkDigit.calculate("0425"));
        assertEquals("4", checkDigit.calculate("4912349"));
        // when check digit is "0"
        assertEquals("0", checkDigit.calculate("20151119"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        CheckDigitService checkDigit = new M10W31();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(""));
        assertThrows(NumberFormatException.class, () -> checkDigit.calculate("0425あ"));
    }

    @Test
    void isValid() {
        CheckDigitService checkDigit = new M10W31();
        assertTrue(checkDigit.isValid("201511190"));
        assertFalse(checkDigit.isValid("201501190"));
    }

    @Test
    void isValidWithInvalidArgument() {
        CheckDigitService checkDigit = new M10W31();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid(""));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid("1"));
    }
}