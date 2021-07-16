package quarter01.level01.lesson06;

public class Dog extends Animal {
    private static int count;

    public Dog(String name) {
        super(name, "Dog", 500, 10);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
