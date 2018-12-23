package ru.poletskiy.se.lesson23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main
{
    public static void main( String[] args )
    {
        printWords();
        printPhoneBook();
    }

    private static void printWords() {
        ArrayList<String> words = new ArrayList<String>();
        words.add("Москва");
        words.add("Берлин");
        words.add("Рим");
        words.add("Париж");
        words.add("Берлин");
        words.add("Прага");
        words.add("Мадрид");
        words.add("Вашингтон");
        words.add("Киев");
        words.add("Минск");
        words.add("Дубаи");
        words.add("Кишинев");
        words.add("Вильнюс");
        words.add("Будапешт");
        words.add("Торонто");
        words.add("Бразилиа");
        words.add("Токио");
        words.add("Пекин");
        words.add("Юрмала");
        words.add("Санкт-Петербург");
        words.add("Киев");
        words.add("Рязань");
        words.add("Сочи");
        words.add("Юрмала");
        words.add("Омск");
        words.add("Новосибирск");
        words.add("Казань");
        words.add("Владивосток");
        words.add("Хабаровск");
        words.add("Красноярск");
        HashSet<String> uniqueWords = new HashSet<String>();
        HashMap<String, Integer> repeatCount = new HashMap<String, Integer>();
        for (String word : words) {
            uniqueWords.add(word);
            if (repeatCount.containsKey(word)) {
                int curValue = repeatCount.replace(word, repeatCount.get(word) + 1);
            } else {
                repeatCount.put(word, 1);
            }
        }
        System.out.println("Уникальные слова (" + uniqueWords.size() + " шт.):");
        for (String word : uniqueWords) System.out.println(word);
        System.out.println("Количество повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : repeatCount.entrySet()) System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    private static void printPhoneBook() {
        PhoneBook book = new PhoneBook();
        book.add("Иванов","111111");
        book.add("Петров","222222");
        book.add("Сидоров","333333");
        book.add("Петров","444444");
        book.add("Петров","444444");
        book.get("Петров");
        book.get("Сидоров");
    }
}
