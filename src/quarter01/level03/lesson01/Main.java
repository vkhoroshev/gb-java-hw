package quarter01.level03.lesson01;

public class Main {
    public static void main(String[] args) {
        FruitBox<Apple> box1 = new FruitBox<>();
        box1.add(new Apple(1.0f));
        box1.add(new Apple(1.0f));
        box1.add(new Apple(1.0f));

        FruitBox<Orange> box2 = new FruitBox<>(
                new Orange(1.5f),
                new Orange(1.5f));

        System.out.println(box1.compare(box2));
    }
}
