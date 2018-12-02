package ru.poletskiy.se.lesson17;

public class Dog extends Animal {

    public Dog(String _name, int _age) {
        this.name = _name;
        this.age = _age;
        this.run_distance_limit = 500;
        this.swim_distance_limit = 10;
        this.jump_height_limit = 0.5;
    }

}
