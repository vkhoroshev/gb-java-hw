package quarter.one.level.one.lesson.seven;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Bilbo", 10),
                new Cat("Arwen", 3),
                new Cat("Frodo"),
                new Cat("Sam"),
                new Cat("Eowyn", 4),
        };

        Plate plate = new Plate(20);
        System.out.println(plate + "\n");

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat + "\n");
        }
    }
}
