package quarter.one.level.one.lesson.one;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
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
}
