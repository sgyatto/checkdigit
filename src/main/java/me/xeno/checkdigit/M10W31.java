package me.xeno.checkdigit;

/**
 * This class calculates a check digit with Modulus 10, Weight 3:1 algorithm.
 */
public class M10W31 implements CheckDigitService {

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

            if (i % 2 != 0) {
                sum += (digit * 3);
            } else {
                sum += digit;
            }
        }

        long mod = sum % 10;
        return String.valueOf((mod == 0) ? 0 : 10 - mod);
    }
}