package quarter.one.level.one.lesson.six;

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
