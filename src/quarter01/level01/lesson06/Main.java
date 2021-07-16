package quarter01.level01.lesson06;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Bilbo"),
                new Dog("Frodo"),
                new Dog("Sam"),
                new Cat("Arwen"),
                new Cat("Eowyn")
        };

        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(20);
        }

        System.out.println();
        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("Всего собак: " + Dog.getCount());
        System.out.println("Всего котов: " + Cat.getCount());
    }
}
