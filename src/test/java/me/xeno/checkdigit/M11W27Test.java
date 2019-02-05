package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class M11W27Test {

    @Test
    void calculateCheckDigit() {
        CheckDigitService checkDigit = new M11W27();
        assertEquals("8", checkDigit.calculate("7"));
        assertEquals("3", checkDigit.calculate("4912349"));
        assertEquals("3", checkDigit.calculate("04912349"));
        assertEquals("4", checkDigit.calculate("20151119"));
        // when check digit is "0"
        assertEquals("0", checkDigit.calculate("22151119"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        CheckDigitService checkDigit = new M11W27();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(""));
        assertThrows(NumberFormatException.class, () -> checkDigit.calculate("0425a"));
    }

    @Test
    void isValid() {
        CheckDigitService checkDigit = new M11W27();
        assertTrue(checkDigit.isValid("201511194"));
        assertFalse(checkDigit.isValid("201511184"));
    }

    @Test
    void isValidWithInvalidArgument() {
        CheckDigitService checkDigit = new M11W27();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid(""));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid("1"));
    }
}