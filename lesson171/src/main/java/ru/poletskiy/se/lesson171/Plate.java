package ru.poletskiy.se.lesson171;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if ((food - n) < 0) {
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

    public void addFood(int n) {
        food += n;
        System.out.println("Добавлено " + n + " еды в тарелку.");
    }
}
