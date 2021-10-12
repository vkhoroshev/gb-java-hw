package quarter01.level03.lesson01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitBox<T extends Fruit> {
    private List<T> fruits;

    public FruitBox() {
        this.fruits = new ArrayList<>();
    }

    public FruitBox(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float weight = 0.0f;

        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(FruitBox<?> fruitBox) {
        return Math.abs(this.getWeight() - fruitBox.getWeight()) < 0.00001;
    }

    public void transfer(FruitBox<? super T> fruitBox) {
        if (fruitBox.equals(this)) {
            return;
        }

        fruitBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }
}
