package quarter01.level01.lesson01;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("_Orange");
        System.out.println("_Banana");
        System.out.println("_Apple");
    }

    public static void checkSumSign() {
        int a = (int) ((Math.random() * 100) * (Math.random() > 0.5 ? 1 : -1));
        int b = (int) ((Math.random() * 100) * (Math.random() > 0.5 ? 1 : -1));
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = (int) ((Math.random() * 255) * (Math.random() > 0.5 ? 1 : -1));
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = (int) ((Math.random() * 100) * (Math.random() > 0.5 ? 1 : -1));
        int b = (int) ((Math.random() * 100) * (Math.random() > 0.5 ? 1 : -1));
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
