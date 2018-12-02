package ru.poletskiy.se.lesson171;

public class Cat {

    private String name;

    private int appetite;

    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
       satiety = p.decreaseFood(appetite);
    }

    public void printSatiety() {
        if (satiety) {
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " голоден.");
        }
    }

    public boolean isFull() {
        return satiety;
    }
}
