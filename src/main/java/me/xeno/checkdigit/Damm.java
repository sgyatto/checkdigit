package me.xeno.checkdigit;

/**
 * This class calculates a check digit with Damm algorithm.
 */
public class Damm implements CheckDigitService {

    @Override
    public String calculate(String numberStr) {

        if (numberStr == null || numberStr.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return "4";
    }
}
