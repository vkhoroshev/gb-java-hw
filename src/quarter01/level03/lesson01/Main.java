package quarter01.level03.lesson01;

import java.util.ArrayList;
import java.util.Arrays;

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

        String[] array = {"Один", "Два", "Три"};
        System.out.println(arrayToArrayList(array));

        swap(array, 0, 2);
        System.out.println(Arrays.toString(array));
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static <T> void swap(T[] array, int index1, int index2) {
        T object = array[index1];
        array[index1] = array[index2];
        array[index2] = object;
    }
}
