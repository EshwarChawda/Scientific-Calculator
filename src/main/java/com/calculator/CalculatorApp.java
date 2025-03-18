package com.calculator;

import java.util.Scanner;
//test
public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScientificCalculator calculator = new ScientificCalculator();

        while (true) {
            System.out.println("\nScientific Calculator Menu");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power (x^b)");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        double num1 = scanner.nextDouble();
                        System.out.println("Result: " + calculator.squareRoot(num1));
                        break;
                    case 2:
                        System.out.print("Enter integer: ");
                        int num2 = scanner.nextInt();
                        System.out.println("Result: " + calculator.factorial(num2));
                        break;
                    case 3:
                        System.out.print("Enter number: ");
                        double num3 = scanner.nextDouble();
                        System.out.println("Result: " + calculator.naturalLog(num3));
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exponent = scanner.nextDouble();
                        System.out.println("Result: " + calculator.power(base, exponent));
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
