package roman;

import java.util.TreeMap;

public class Number {

    private static TreeMap<Integer, String> ROMAN_MAP = new TreeMap<>();

    static {
        ROMAN_MAP.put(1, "I");
        ROMAN_MAP.put(4, "IV");
        ROMAN_MAP.put(5, "V");
        ROMAN_MAP.put(9, "IX");
        ROMAN_MAP.put(10, "X");
        ROMAN_MAP.put(40, "XL");
        ROMAN_MAP.put(50, "L");
        ROMAN_MAP.put(90, "XC");
        ROMAN_MAP.put(100, "C");
        ROMAN_MAP.put(400, "CD");
        ROMAN_MAP.put(500, "D");
        ROMAN_MAP.put(900, "CM");
        ROMAN_MAP.put(1000, "M");
    }

    public String convertToRoman(int number) {
        int floorKey = ROMAN_MAP.floorKey(number);
        if (floorKey == number) {
            return ROMAN_MAP.get(number);
        }
        return ROMAN_MAP.get(floorKey) + convertToRoman(number - floorKey);
    }

    public String intToRoman(int num) {
        // storing roman values of digits from 0-9
        // when placed at different places
        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};

        // Converting to roman
        String thousands = m[num / 1000];
        String hundreds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];

        String ans = thousands + hundreds + tens + ones;

        return ans;
    }


}
