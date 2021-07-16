package quarter01.level01.lesson03;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        taskOne();
        System.out.println();

        taskTwo();
        System.out.println();

        taskThree();
        System.out.println();

        taskFour(9);
        System.out.println();

        int[] array1 = getArray(10, 8);
        System.out.println(Arrays.toString(array1));
        System.out.println();

        taskSix();
        System.out.println();

        int[] array2 = getRandomIntArray(8, 3, true);
        System.out.println(Arrays.toString(array2));
        System.out.println(checkBalance(array2));
        System.out.println();
    }

    /**
     * Формирует массив случайных целых чисел.
     */
    public static int[] getRandomIntArray(int size, int range, boolean notNegative) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(range * 2 + 1) - range;
            if (notNegative) {
                array[i] = Math.abs(array[i]);
            }
        }
        return array;
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0.
     */
    public static void taskOne() {
        int[] array = getRandomIntArray(10, 1, true);
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 2. Задать пустой целочисленный массив длиной 100.
     * С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100.
     */
    public static void taskTwo() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     * пройти по нему циклом, и числа меньшие 6 умножить на 2.
     */
    public static void taskThree() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
     * Определить элементы одной из диагоналей можно по следующему принципу:
     * индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n].
     */
    public static void taskFour(int size) {
        int[][] array = new int[size][size];

        size--;
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][size - i] = 1;
        }

        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 5. Написать метод, принимающий на вход два аргумента: len и initialValue,
     * и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
     */
    public static int[] getArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    /**
     * 6. (*) Задать одномерный массив и найти в нем минимальный и максимальный элементы.
     */
    public static void taskSix() {
        int[] array = getRandomIntArray(10, 50, false);
        int min = array[0];
        int max = array[0];

        for (int i : array) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println("min: " + min);
        System.out.println("max: " + max);
    }

    /**
     * 7. (**) Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     *
     * Примеры:
     *  checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
     *  checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
     *  checkBalance([1, 14, 1, ||| 2, 1, 6, 7]) → true, т.е. 1 + 14 + 1 = 2 + 1 + 6 + 7
     */
    public static boolean checkBalance(int[] array) {
        // Изначально считаем, что результат ложный.
        boolean result = false;

        // Находим сумму элементов массива.
        int sum = 0;
        for (int i : array){
            sum += i;
        }

        // Если середина не целое число, то делаем возврат.
        if (sum % 2 != 0) {
            return result;
        }
        int middle = sum / 2;

        // Начинаем считать сумму элементов слева.
        int sumLeft = 0;
        for (int i : array) {
            sumLeft += i;
            if (sumLeft >= middle) {
                result = (sumLeft == middle);
                break;
            }
        }
        return result;
    }
}
