package ru.poletskiy.se.lesson12;

import java.util.Arrays;

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

    }
}
