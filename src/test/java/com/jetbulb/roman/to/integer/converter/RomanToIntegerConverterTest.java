package com.jetbulb.roman.to.integer.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntegerConverterTest {

    private static final Character[] lowerCaseAlphabet = {
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };

    private static final List<String> nonRomanDigits = Arrays.stream(lowerCaseAlphabet)
            .filter(c -> !RomanToIntegerConverter.ROMAN_DIGITS.contains(c))
            .map(Object::toString)
            .toList();

    @ParameterizedTest
    @CsvSource(value = {
            "III,3",
            "LVIII,58",
            "MCMXCIV,1994",
    })
    void shouldConvertRomanDigitToInteger_whenGivenRomanIsValid(String actualRoman, int expectedInteger) {
        var actual = RomanToIntegerConverter.convert(actualRoman);
        assertThat(actual).isEqualTo(expectedInteger);
    }

    @ParameterizedTest
    @MethodSource("nonRomanDigitsProvider")
    void shouldNotConvertRomanDigitToInteger_whenGivenRomanIsInvalid(String actualNonRoman) {
        var actual = RomanToIntegerConverter.convert(actualNonRoman);
        assertThat(actual).isZero();
    }

    private static List<String> nonRomanDigitsProvider() {
        return nonRomanDigits;
    }
}