package ru.poletskiy.se.lesson17;

public abstract class Animal {

    public int run_distance_limit;

    public int swim_distance_limit;

    public double jump_height_limit;

    public String name;

    public int age;

    public void run (int distance) {
        if (distance <= 0 || distance > run_distance_limit ) {
            System.out.println("Результат " + name + " run(" + distance + "): false");
            return;
        }
        System.out.println("Результат " + name + " run(" + distance + "): true");
    };

    public void swim (int distance) {
        if (distance <= 0 || distance > swim_distance_limit ) {
            System.out.println("Результат " + name + " swim(" + distance + "): false");
            return;
        }
        System.out.println("Результат " + name + " swim(" + distance + "): true");

    };

    public void jump (int height) {
        if (height <= 0 || height > jump_height_limit ) {
            System.out.println("Результат " + name + " jump(" + height + "): false");
            return;
        }
        System.out.println("Результат " + name + " jump(" + height + "): true");
    };

}
