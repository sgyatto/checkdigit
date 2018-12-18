package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnTest {

    @Test
    void calculateCheckDigit() {
        Luhn luhn = new Luhn();
        assertEquals("2", luhn.calculateCheckDigit("4"));
        assertEquals("9", luhn.calculateCheckDigit("425"));
        assertEquals("9", luhn.calculateCheckDigit("0425"));
        assertEquals("7", luhn.calculateCheckDigit("176048"));
        assertEquals("3", luhn.calculateCheckDigit("20151119"));
        // when check digit is "0"
        assertEquals("0", luhn.calculateCheckDigit("20151149"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        Luhn luhn = new Luhn();
        assertThrows(IllegalArgumentException.class, () -> luhn.calculateCheckDigit(null));
        assertThrows(IllegalArgumentException.class, () -> luhn.calculateCheckDigit(""));
        assertThrows(NumberFormatException.class, () -> luhn.calculateCheckDigit("0425あ"));
    }

    @Test
    void isValid() {
        Luhn luhn = new Luhn();
        assertTrue(luhn.isValid("201511490"));
        assertFalse(luhn.isValid("201511480"));
    }

    @Test
    void isValidWithInvalidArgument() {
        Luhn luhn = new Luhn();
        assertThrows(IllegalArgumentException.class, () -> luhn.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> luhn.isValid(""));
    }

    @Test
    void generateCode() {
        Luhn luhn = new Luhn();
        assertEquals("1762483", luhn.generateCode("176248"));
    }

    @Test
    void generateCodeWithInvalidArgument() {
        Luhn luhn = new Luhn();
        assertThrows(IllegalArgumentException.class, () -> luhn.generateCode(null));
        assertThrows(IllegalArgumentException.class, () -> luhn.generateCode(""));
    }
}