package ru.poletskiy.se.lesson23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String, HashSet<String>> book = new HashMap<String, HashSet<String>>();

    public void add(String name, String phone) {
        HashSet<String> phones = new HashSet<String>();
        if (book.containsKey(name)) phones = book.get(name);
        phones.add(phone);
        book.put(name, phones);
    }

    public void get(String name) {
        HashSet<String> phones = new HashSet<String>();
        phones = book.get(name);
        System.out.println();
        System.out.println(name);
        int i = 1;
        for (String phone : phones) {
            System.out.println("Телефон " + i + ": " + phone);
            i++;
        }
    }
}
