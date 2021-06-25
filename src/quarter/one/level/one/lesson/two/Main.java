package quarter.one.level.one.lesson.two;

import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        boolean result = checkSum(random.nextInt(20), random.nextInt(20));
        System.out.println(result);
    }

    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
     * в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        return (sum >= 10) && (sum <= 20);
    }
}
