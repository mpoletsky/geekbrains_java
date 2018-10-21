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
    }
}
