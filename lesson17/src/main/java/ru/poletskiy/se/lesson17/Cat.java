package ru.poletskiy.se.lesson17;

public class Cat extends Animal {

    public Cat(String _name, int _age) {
        this.name = _name;
        this.age = _age;
        this.run_distance_limit = 200;
        this.swim_distance_limit = 0;
        this.jump_height_limit = 2;
    }
}
