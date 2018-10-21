package ru.poletskiy.se;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        byte b = 127;
        short s = 32767;
        int i = 2147483647;
        long l = 9223372036854775807L;
        float f = 120.0F;
        double d = 15.234;
        boolean boo = false;
        char c = 'w';

        System.out.println("Method 1 result is: " + method1(3, 4, 10, 2));
        if (method2(2,20)) System.out.println("Method 2 result is: true");
        else System.out.println("Method 2 result is: false");
        method3(-5);
        if (method4(-4)) System.out.println("Method 4 result is: true");
        else System.out.println("Method 4 result is: false");
        System.out.print("Method 5 result is: ");
        method5("Василий");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год");
        int input_year = scanner.nextInt();
        if (method6(input_year)) System.out.println("Method 6 result is: Високосный");
        else System.out.println("Method 6 result is: Невисокосный");
    }

    private static int method1(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    private static boolean method2(int a, int b) {
        int c = a + b;
        if (c >= 10 && c <= 20 ) return true;
        else return  false;
    }

    private static void method3(int a) {
        if (a >= 0) System.out.println("Method 3 result is: Положительное");
        else System.out.println("Method 3 result is: Отрицательное");
    }

    private static boolean method4(int a) {
        if (a >= 0) return false;
        else return true;
    }

    private static void method5(String a) {
        System.out.println("Привет, " + a + "!");
    }

    private static boolean method6(int a) {
        if ((a%400) == 0) return true;
        else if ((a%100) == 0) return false;
        else if ((a%4) == 0) return true;
        else return false;
    }
}
