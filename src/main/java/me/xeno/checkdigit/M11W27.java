package me.xeno.checkdigit;

/**
 * This class calculates a check digit with Modulus 11, Weight from 2 to 7 algorithm.
 */
public class M11W27 {

    /**
     * Calculate a check digit.
     *
     * @param numberStr The digits of string without a check digit.
     * @return A check digit.
     */
    public String calculateCheckDigit(String numberStr) {

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

    /**
     * This function takes a code with a check digit appended to the end,
     * and returns true if the code passes the this algorithm's check.
     *
     * @param code The code with a check digit.
     * @return true or false.
     */
    public boolean isValid(String code) {

        if (code == null || code.length() < 2) {
            throw new IllegalArgumentException();
        }

        String checkDigit = code.substring(code.length() - 1);

        return checkDigit.equals(calculateCheckDigit(code.substring(0, code.length() - 1)));
    }
}