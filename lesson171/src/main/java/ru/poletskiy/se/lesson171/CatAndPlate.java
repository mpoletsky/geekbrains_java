package ru.poletskiy.se.lesson171;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class CatAndPlate
{
    public static void main( String[] args ) {
        List<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("Barsik", 5));
        cats.add(new Cat("Murka", 3));
        cats.add(new Cat("Vasiliy", 7));
        cats.add(new Cat("Boris", 6));
        cats.add(new Cat("Mashka", 4));
        cats.add(new Cat("Koshka", 3));
        cats.add(new Cat("Dashka", 5));
        Plate plate = new Plate(20);
        for (Cat cat:cats) {
            cat.eat(plate);
            cat.printSatiety();
        }
        System.out.println();
        plate.addFood(20);
        System.out.println();
        for (Cat cat:cats) {
            if (!cat.isFull()) {
                cat.eat(plate);
                cat.printSatiety();
            }
        }
    }
}
