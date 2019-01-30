package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class M11W27Test {

    @Test
    void calculateCheckDigit() {
        M11W27 m11w27 = new M11W27();
        assertEquals("8", m11w27.calculateCheckDigit("7"));
        assertEquals("3", m11w27.calculateCheckDigit("4912349"));
        assertEquals("3", m11w27.calculateCheckDigit("04912349"));
        assertEquals("4", m11w27.calculateCheckDigit("20151119"));
        // when check digit is "0"
        assertEquals("0", m11w27.calculateCheckDigit("22151119"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        M11W27 m11w27 = new M11W27();
        assertThrows(IllegalArgumentException.class, () -> m11w27.calculateCheckDigit(null));
        assertThrows(IllegalArgumentException.class, () -> m11w27.calculateCheckDigit(""));
        assertThrows(NumberFormatException.class, () -> m11w27.calculateCheckDigit("0425あ"));
    }

    @Test
    void isValid() {
        M11W27 m11w27 = new M11W27();
        assertTrue(m11w27.isValid("201511194"));
        assertFalse(m11w27.isValid("221511190"));
    }

    @Test
    void isValidWithInvalidArgument() {
        M11W27 m11w27 = new M11W27();
        assertThrows(IllegalArgumentException.class, () -> m11w27.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> m11w27.isValid(""));
        assertThrows(IllegalArgumentException.class, () -> m11w27.isValid("1"));
    }
}