package quarter.one.level.one.lesson.six;

public class Cat extends Animal {
    private static int count;

    public Cat(String name) {
        super(name, "Cat", 200, 0);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
