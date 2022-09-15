package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение: ");
        String text=new Scanner(System.in).nextLine();
        System.out.println(Calculator.calc(text));

    }
}
