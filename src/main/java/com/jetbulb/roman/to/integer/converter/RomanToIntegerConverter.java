package com.jetbulb.roman.to.integer.converter;

import java.util.Set;

public final class RomanToIntegerConverter {

    public static final char R_ONE = 'I';
    public static final char R_FIVE = 'V';
    public static final char R_TEN = 'X';
    public static final char R_FIFTY = 'L';
    public static final char R_HUNDRED = 'C';
    public static final char R_FIVE_HUNDREDS = 'D';
    public static final char R_THOUSAND = 'M';

    public static final Set<Character> ROMAN_DIGITS = Set.of(
            R_ONE, R_FIVE, R_TEN, R_FIFTY, R_HUNDRED, R_FIVE_HUNDREDS, R_THOUSAND
    );

    public static int convert(String value) {
        var upperValue = value.toUpperCase();
        int ans = 0, num = 0;

        for (int i = upperValue.length() - 1; i >= 0; i--) {
            switch (upperValue.charAt(i)) {
                case R_ONE -> num = 1;
                case R_FIVE -> num = 5;
                case R_TEN -> num = 10;
                case R_FIFTY -> num = 50;
                case R_HUNDRED -> num = 100;
                case R_FIVE_HUNDREDS -> num = 500;
                case R_THOUSAND -> num = 1000;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }

        return ans;
    }
}
