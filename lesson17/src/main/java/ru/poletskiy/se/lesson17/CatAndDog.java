package ru.poletskiy.se.lesson17;

/**
 * Cat and Dog
 *
 */
public class CatAndDog
{
    public static void main( String[] args ) {
        Cat borisCat = new Cat("Борис", 1);
        Cat murzikCat = new Cat("Мурзик", 4);
        Cat murkaCat = new Cat("Мурка", 2);
        Dog rexDog = new Dog("Рекс", 5);

        borisCat.run(100);
        borisCat.run(300);
        murzikCat.swim(1);
        murkaCat.jump(1);
        murkaCat.jump(-1);
    }
}
