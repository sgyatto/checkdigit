package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnTest {

    @Test
    void calculateCheckDigit() {
        CheckDigitService checkDigit = new Luhn();
        assertEquals("2", checkDigit.calculate("4"));
        assertEquals("9", checkDigit.calculate("425"));
        assertEquals("9", checkDigit.calculate("0425"));
        assertEquals("7", checkDigit.calculate("176048"));
        assertEquals("3", checkDigit.calculate("20151119"));
        // when check digit is "0"
        assertEquals("0", checkDigit.calculate("20151149"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        CheckDigitService checkDigit = new Luhn();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.calculate(""));
        assertThrows(NumberFormatException.class, () -> checkDigit.calculate("0425あ"));
    }

    @Test
    void isValid() {
        CheckDigitService checkDigit = new Luhn();
        assertTrue(checkDigit.isValid("201511490"));
        assertFalse(checkDigit.isValid("201511480"));
    }

    @Test
    void isValidWithInvalidArgument() {
        CheckDigitService checkDigit = new Luhn();
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid(""));
        assertThrows(IllegalArgumentException.class, () -> checkDigit.isValid("1"));
    }
}