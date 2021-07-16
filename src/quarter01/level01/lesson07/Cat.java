package quarter01.level01.lesson07;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name) {
        this.name = name;
        this.appetite = 5;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void eat(Plate plate) {
        if (plate.decrease(appetite)) {
            satiety = true;
            System.out.println(name + " eat...");
        } else {
            System.out.println(name + " can't eat!");
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}
