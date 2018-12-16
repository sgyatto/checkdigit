package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Mod10W3Test {

    @Test
    void calculateCheckDigit() {
        Mod10W3 mod10w3 = new Mod10W3();
        assertEquals("8", mod10w3.calculateCheckDigit("4"));
        assertEquals("1", mod10w3.calculateCheckDigit("0425"));
        assertEquals("4", mod10w3.calculateCheckDigit("4912349"));
        // when check digit is "0"
        assertEquals("0", mod10w3.calculateCheckDigit("20151119"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        Mod10W3 mod10w3 = new Mod10W3();
        assertThrows(IllegalArgumentException.class, () -> mod10w3.calculateCheckDigit(null));
        assertThrows(IllegalArgumentException.class, () -> mod10w3.calculateCheckDigit(""));
        assertThrows(NumberFormatException.class, () -> mod10w3.calculateCheckDigit("0425あ"));
    }

    @Test
    void isValid() {
        Mod10W3 mod10w3 = new Mod10W3();
        assertTrue(mod10w3.isValid("201511190"));
        assertFalse(mod10w3.isValid("201501190"));
    }

    @Test
    void isValidWithInvalidArgument() {
        Mod10W3 mod10w3 = new Mod10W3();
        assertThrows(IllegalArgumentException.class, () -> mod10w3.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> mod10w3.isValid(""));
    }

    @Test
    void generateCode() {
        Mod10W3 mod10w3 = new Mod10W3();
        assertEquals("4901234567894", mod10w3.generateCode("490123456789"));
    }

    @Test
    void generateCodeWithInvalidArgument() {
        Mod10W3 mod10w3 = new Mod10W3();
        assertThrows(IllegalArgumentException.class, () -> mod10w3.generateCode(null));
        assertThrows(IllegalArgumentException.class, () -> mod10w3.generateCode(""));
    }
}