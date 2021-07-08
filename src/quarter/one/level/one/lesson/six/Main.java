package quarter.one.level.one.lesson.six;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Sharik"),
                new Dog("Druzok"),
                new Cat("Murka"),
                new Cat("Larisa")
        };
        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(20);
        }
    }
}
