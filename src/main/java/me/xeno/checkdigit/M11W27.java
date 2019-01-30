package me.xeno.checkdigit;

/**
 * This class calculates a check digit with Modulus 11, Weight from 2 to 7 algorithm.
 */
public class M11W27 implements CheckDigitService {

    @Override
    public String calculate(String numberStr) {

        if (numberStr == null || numberStr.isEmpty()) {
            throw new IllegalArgumentException();
        }

        long sum = 0;

        for (int i = 1; i <= numberStr.length(); i++) {

            int digit = Character.digit(numberStr.charAt(numberStr.length() - i), 10);

            // Checking Number String
            if (digit < 0) throw new NumberFormatException();

            int weights[] = { 2, 3, 4, 5, 6, 7 };

            sum += digit * weights[(i - 1) % weights.length];
        }

        long mod = sum % 11;
        return String.valueOf((mod == 0) ? 0 : 11 - mod);
    }
}