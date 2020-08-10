package roman;

import java.util.List;

public class RomanArabicConverter {

    public static int romanToArabic(final String input) {
        String romanNumeral = input.toUpperCase();

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        int i = 0;
        int result = 0;
        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }
        return result;
    }

    public static String arabicToRoman(int num) {
        if (num <= 0 || num >= 4000) {
            throw new IllegalArgumentException("The number should be in the range of [1...3999]");
        }

        final StringBuilder result = new StringBuilder();
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
        int i = 0;
        while (num > 0 && i < romanNumerals.size()) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= num) {
                result.append(currentSymbol.name());
                num = num - currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return result.toString();
    }
}
