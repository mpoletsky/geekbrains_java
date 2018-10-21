package ru.poletskiy.se.lesson12;

import java.util.Arrays;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        // Задание 1
        int[] task1IntArray = new int[]{ 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1};
        System.out.println("Задание 1. Исходный массив: " + Arrays.toString(task1IntArray));
        for (int i = 0; i < task1IntArray.length; i++) {
            if (task1IntArray[i] == 0) task1IntArray[i] = 1;
            else task1IntArray[i] = 0;
        }
        System.out.println("Задание 1. Результат:       " + Arrays.toString(task1IntArray));
        System.out.println();
        // Задание 2
        int[] task2IntArray = new int[8];
        for (int i = 0, j = 0; i < 8; i++, j+=3) task2IntArray[i] = j;
        System.out.println("Задание 2. Результат:       " + Arrays.toString(task2IntArray));
        System.out.println();
        // Задание 3
        int[] task3IntArray = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Задание 3. Исходный массив: " + Arrays.toString(task3IntArray));
        for (int i = 0;  i < task3IntArray.length; i++) {
            if (task3IntArray[i] < 6) task3IntArray[i] = task3IntArray[i] * 2;
        }
        System.out.println("Задание 3. Результат:       " + Arrays.toString(task3IntArray));
        System.out.println();
        // Задание 4
        int[][] task4IntArray = new int[10][10];
        System.out.println("Задание 4. Исходный массив: ");
        for (int i = 0; i < 10; i++) System.out.println(Arrays.toString(task4IntArray[i]));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boolean isDiagonal = (i == j) || (i + j == 9);
                if (isDiagonal) task4IntArray[i][j] = 1;
            }
        }
        System.out.println("Задание 4. Результат: ");
        for (int i = 0; i < 10; i++) System.out.println(Arrays.toString(task4IntArray[i]));
        System.out.println();
        // Задание 5
        int[] task5IntArray = new int[]{ 1, 10, 4, 8, 24, 56, 21, 5, 7, 4, 2 };
        int maxValue = task5IntArray[0];
        int minValue = task5IntArray[0];
        System.out.println("Задание 5. Исходный массив: " + Arrays.toString(task5IntArray));
        for (int i = 0; i < task5IntArray.length; i++) {
            if (task5IntArray[i] > maxValue) maxValue = task5IntArray[i];
            if (task5IntArray[i] < minValue) minValue = task5IntArray[i];
        }
        System.out.println("Задание 5. Результат: минимальное значение = " + minValue + ", максимальное значение = " + maxValue);
        System.out.println();
        // Задание 6
        int[] task6IntArray = new int[]{ 48, 10, 4, 8, 24, 56, 21, 5, 7, 4, 2 };
        System.out.println("Задание 6. Исходный массив: " + Arrays.toString(task6IntArray));
        System.out.print("Задание 6. Результат: ");
        if (checkBalance(task6IntArray)) System.out.println("В массиве ЕСТЬ место, в котором сумма левой и правой частей массива равны");
        else System.out.println("В массиве НЕТ места, в котором сумма левой и правой частей массива равны");
        System.out.println();
        // Задание 7
        int[] task7IntArray = new int[]{ 48, 10, 4, 8, 24, 56, 21, 5, 7, 4, 2 };
        System.out.println("Задание 7. Исходный массив: " + Arrays.toString(task7IntArray));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество позиций, на которое нужно сдвинуть массив (положительное число - вправо, отрицательное - влево): ");
        int countPosition = scanner.nextInt();
        System.out.println("Задание 7. Результат:       " + Arrays.toString(shiftArrayElements(task7IntArray, countPosition)));
        System.out.println();
    }

    private static boolean checkBalance(int[] checkedArray) {
        int leftSideSum = 0;
        int rightSideSum = Arrays.stream(checkedArray).sum();
        if (leftSideSum == rightSideSum) return true;
        for (int i = 0; i < checkedArray.length; i++) {
            leftSideSum += checkedArray[i];
            rightSideSum -= checkedArray[i];
            if (leftSideSum == rightSideSum) return true;
        }
        return false;
    }

    private static int[] shiftArrayElements(int[] shiftedArray, int countPosition) {
        for (int j = 0; j < Math.abs(countPosition); j++) {
            int firstElement = shiftedArray[0];
            int lastElement = shiftedArray[shiftedArray.length - 1];
            if (countPosition >= 0) {
                for (int i = shiftedArray.length - 1; i >= 0; i--) {
                    if (i == 0) shiftedArray[i] = lastElement;
                    else shiftedArray[i] = shiftedArray[i - 1];
                }
            } else {
                for (int i = 0; i < shiftedArray.length; i++) {
                    if (i == shiftedArray.length - 1) shiftedArray[i] = firstElement;
                    else shiftedArray[i] = shiftedArray[i + 1];
                }
            }
        }
        return shiftedArray;
    }
}
