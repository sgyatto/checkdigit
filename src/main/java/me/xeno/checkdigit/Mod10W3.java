package me.xeno.checkdigit;

public class Mod10W3 {

    /**
     * Calculate CheckDigit
     *
     * @param numberStr target value
     */
    public String calculateCheckDigit(String numberStr) {

        if (numberStr == null || numberStr.isEmpty()) {
            throw new IllegalArgumentException();
        }

        long sum = 0;
        int position = 1;

        while (position <= numberStr.length()) {

            int digit = Character.digit(numberStr.charAt(numberStr.length() - position), 10);

            // Checking Number String
            if (digit < 0) throw new NumberFormatException();

            if (position % 2 != 0) {
                sum += (digit * 3);
            } else {
                sum += digit;
            }
            position++;
        }

        long mod = sum % 10;
        return String.valueOf((mod == 0) ? 0 : 10 - mod);
    }
}