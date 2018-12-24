package me.xeno.checkdigit;

/**
 * This class calculates a check digit with Modulus 10, Weight 3:1 algorithm.
 */
public class M10W31 {

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

            if (i % 2 != 0) {
                sum += (digit * 3);
            } else {
                sum += digit;
            }
        }

        long mod = sum % 10;
        return String.valueOf((mod == 0) ? 0 : 10 - mod);
    }

    /**
     * This function takes a code with a check digit appended to the end,
     * and returns true if the code passes this algorithm's check.
     *
     * @param code The code with a check digit.
     * @return true or false.
     */
    public boolean isValid(String code) {

        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String checkDigit = code.substring(code.length() - 1);

        return checkDigit.equals(calculateCheckDigit(code.substring(0, code.length() - 1)));
    }

    /**
     * Generate a code with a check digit appended to the end.
     *
     * @param numberStr The digits of string without a check digit.
     * @return A code with a check digit.
     */
    public String generateCode(String numberStr) {

        if (numberStr == null || numberStr.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return numberStr + calculateCheckDigit(numberStr);
    }
}