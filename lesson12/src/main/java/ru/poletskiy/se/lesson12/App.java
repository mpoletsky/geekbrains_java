package ru.poletskiy.se.lesson12;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        // Задание 1
        int[] task1IntArray = new int[]{1,1,0,1,0,0,1,1,0,0,0,1};
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
    }
}
