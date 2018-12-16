package me.xeno.checkdigit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Mod10W3Test {

    @Test
    void returnCheckDigit() {
        Mod10W3 mod10w3 = new Mod10W3();
        assertEquals("8", mod10w3.calculateCheckDigit("4"));
        assertEquals("1", mod10w3.calculateCheckDigit("0425"));
        assertEquals("4", mod10w3.calculateCheckDigit("4912349"));
        assertEquals("0", mod10w3.calculateCheckDigit("20151119"));
    }

    @Test
    void calculateCheckDigitWithInvalidArgument() {
        Mod10W3 mod10w3 = new Mod10W3();
        assertThrows(IllegalArgumentException.class, () -> mod10w3.calculateCheckDigit(null));
        assertThrows(IllegalArgumentException.class, () -> mod10w3.calculateCheckDigit(""));
        assertThrows(NumberFormatException.class, () -> mod10w3.calculateCheckDigit("0425あ"));
    }
}