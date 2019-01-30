package me.xeno.checkdigit;

public interface CheckDigitService {

    /**
     * Calculate a check digit.
     *
     * @param numberStr The digits of string without a check digit.
     * @return A check digit.
     */
    String calculate(String numberStr);

    /**
     * This function takes a code with a check digit appended to the end,
     * and returns true if the code passes this algorithm's check.
     *
     * @param code The code with a check digit.
     * @return true or false.
     */
    default boolean isValid(String code) {

        if (code == null || code.length() < 2) {
            throw new IllegalArgumentException();
        }

        String checkDigit = code.substring(code.length() - 1);

        return checkDigit.equals(calculate(code.substring(0, code.length() - 1)));
    }
}
