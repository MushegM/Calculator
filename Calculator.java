package calculator;
import java.util.*;

public class Calculator {

    private final static List<String> ARABIC = Arrays.asList("10", "9", "8", "7", "6", "5", "4", "3", "2", "1");
    private final static List<String> ROMAN = Arrays.asList("X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I");

    public static String calc(String input) throws Exception {
        String[] split = input.split("[-+/*]");
        if (split.length != 2)
            throw new Exception("Неверное выражение, более 2х");

        int first;
        int second;
        char sign = input.charAt(split[0].length());

        if (isRoman(split[0]) && isRoman(split[1])) {
            first = Integer.parseInt(ARABIC.get(ROMAN.indexOf(split[0])));
            second = Integer.parseInt(ARABIC.get(ROMAN.indexOf(split[1])));
            if (first <= second && sign == '-')
                throw new Exception("Неверное выражение");
            return ROMAN.get(ARABIC.indexOf(String.valueOf(Calk.calculate(first, second, sign))));

        } else if (isArabic(split[0]) && isArabic(split[1])) {
            first = Integer.parseInt(split[0]);
            second = Integer.parseInt(split[1]);

        } else
            throw new Exception("Ошибка: разные символы");
        return String.valueOf(Calk.calculate(first, second, sign));
    }

    private static boolean isArabic(String number) {
        return ARABIC.contains(number);
    }

    private static boolean isRoman(String number) {
        return ROMAN.contains(number);
    }

    static class Calk {
        static int calculate(int number1, int number2, char operation) {
            switch (operation) {
                case '+':
                    return number1 + number2;
                case '-':
                    return number1 - number2;
                case '*':
                    return number1 * number2;
                case '/':
                    return number1 / number2;
                default:
                    throw new IllegalArgumentException("Не верный знак операции");
            }
        }
    }
}



