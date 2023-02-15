package Calculator;

import java.util.Scanner;

import static Calculator.Util.CheckNumbers;
import static Calculator.RomanNumber.*;

class Calculation {
    private static boolean calculation;

    public static void StartCalculation() {
        calculation = true;

        while (calculation) {
            System.out.println("Обратите внимание, калькулятор работает с арабскими и римскими цифрами от 1 до 10 включительно");
            Scanner sc = new Scanner(System.in);
            String lineOperation = sc.nextLine();
            String[] arrOperation = lineOperation.split(" ");

            if (RomanOrArabic(arrOperation[0]) & RomanOrArabic(arrOperation[2])) {
                System.out.println(RomanCalculate(arrOperation));
                if (RomanCalculate(arrOperation).equals("Не предусмотренная арифметическая операция") || RomanCalculate(arrOperation).equals("В римских цифрах нет отрицательных чисел")) {
                    calculation = false;
                }
            } else  if (!RomanOrArabic(arrOperation[0]) & !RomanOrArabic(arrOperation[2])){
                ArabicCalculation(arrOperation);
            } else {
                System.out.println("Не корректные данные, оба операнда должны быть либо арабскими, либо римскими цифрами");
                calculation = false;
            }
        }
    }

    public static void ArabicCalculation(String[] arrOperation) {
        if (CheckNumbers(arrOperation)) {
            switch (arrOperation[1]) {
                case "+":
                    System.out.println(Integer.parseInt(arrOperation[0]) + Integer.parseInt(arrOperation[2]));
                    break;
                case "-":
                    System.out.println(Integer.parseInt(arrOperation[0]) - Integer.parseInt(arrOperation[2]));
                    break;
                case "*":
                    System.out.println(Integer.parseInt(arrOperation[0]) * Integer.parseInt(arrOperation[2]));
                    break;
                case "/":
                    System.out.println(Integer.parseInt(arrOperation[0]) / Integer.parseInt(arrOperation[2]));
                    break;
                default:
                    System.err.println("Не предусмотренная арифметическая операция");
                    calculation = false;
            }
        } else {
            if (arrOperation.length == 3) {
                System.err.println("Калькулятор принимает на вход числа от 1 до 10 включительно");
            }
            calculation = false;
        }
    }
}