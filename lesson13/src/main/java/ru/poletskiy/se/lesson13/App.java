package ru.poletskiy.se.lesson13;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Guess the word!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        final Random randomInt = new Random();
        final int wordIndex = randomInt.nextInt(25);
        final String randomWord = words[wordIndex];
        final Scanner scanner = new Scanner(System.in);
        String userWord;
        do {
            System.out.println("Выберите слово из списка: " + Arrays.toString(words));
            userWord = scanner.nextLine();
            if (!Arrays.asList(words).contains(userWord)) {
                System.out.println("Введенного слова нет в списке. Введите другое слово.");
            } else if (!randomWord.equals(userWord)) {
                System.out.println("Не совсем: " + compareWords(randomWord, userWord) + " Попробуйте еще раз.");
                System.out.println();
            } else {
                System.out.println("Поздравляем! Вы угадали.");
            }
        } while (!randomWord.equals(userWord));
    }

    private static String compareWords(String word1, String word2) {
        String resultString = "";
        for (int i = 0; i < 15; i++) {
            boolean isComparedCharsExists = word1.length() >= i + 1 && word2.length() >= i + 1;
            if (!isComparedCharsExists) {
                resultString += "#";
            } else {
                if (word1.charAt(i) == word2.charAt(i)) resultString += word1.charAt(i);
                else resultString += "#";
            }
        }
        return resultString;
    }
}
