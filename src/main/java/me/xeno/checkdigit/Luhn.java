package me.xeno.checkdigit;

/**
 * This class calculates a check digit with Luhn algorithm.
 */
public class Luhn {

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
                int doubleVal = digit * 2;
                sum += (doubleVal > 9) ? (doubleVal - 9) : doubleVal;
            } else {
                sum += digit;
            }
        }

        long mod = sum % 10;
        return String.valueOf((mod == 0) ? 0 : 10 - mod);
    }

    /**
     * This function takes a code with a check digit appended to the end,
     * and returns true if the code passes the LUHN check.
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
}