package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class M10W31Test {

    @Test
    void calculateCheckDigit() {
        M10W31 m10W31 = new M10W31();
        assertEquals("8", m10W31.calculateCheckDigit("4"));
        assertEquals("1", m10W31.calculateCheckDigit("0425"));
        assertEquals("4", m10W31.calculateCheckDigit("4912349"));
        // when check digit is "0"
        assertEquals("0", m10W31.calculateCheckDigit("20151119"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        M10W31 m10W31 = new M10W31();
        assertThrows(IllegalArgumentException.class, () -> m10W31.calculateCheckDigit(null));
        assertThrows(IllegalArgumentException.class, () -> m10W31.calculateCheckDigit(""));
        assertThrows(NumberFormatException.class, () -> m10W31.calculateCheckDigit("0425あ"));
    }

    @Test
    void isValid() {
        M10W31 m10W31 = new M10W31();
        assertTrue(m10W31.isValid("201511190"));
        assertFalse(m10W31.isValid("201501190"));
    }

    @Test
    void isValidWithInvalidArgument() {
        M10W31 m10W31 = new M10W31();
        assertThrows(IllegalArgumentException.class, () -> m10W31.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> m10W31.isValid(""));
    }

    @Test
    void generateCode() {
        M10W31 m10W31 = new M10W31();
        assertEquals("4901234567894", m10W31.generateCode("490123456789"));
    }

    @Test
    void generateCodeWithInvalidArgument() {
        M10W31 m10W31 = new M10W31();
        assertThrows(IllegalArgumentException.class, () -> m10W31.generateCode(null));
        assertThrows(IllegalArgumentException.class, () -> m10W31.generateCode(""));
    }
}