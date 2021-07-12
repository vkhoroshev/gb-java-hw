package quarter.one.level.one.lesson.seven;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decrease(int amount) {
        if (amount < 0 || amount > food) {
            return false;
        }
        food -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
