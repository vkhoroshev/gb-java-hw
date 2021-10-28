package quarter01.level03.lesson06.main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Пример использования JUnit");
    }

    /**
     * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
     * иначе в методе необходимо выбросить RuntimeException.
     */
    public static int[] arrayAfterNumber(int[] array, int number) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == number) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }
        throw new RuntimeException("В массиве нет цифры " + number);
    }

    /**
     * Написать метод, который проверяет состав массива из чисел 1 и 4.
     * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     * Если есть что то кроме 1 или 4 то вернется false;
     */
    public static boolean arrayContainsOnlyTheseNumbers(int[] array, int number1, int number2) {
        boolean hasNumber1 = false;
        boolean hasNumber2 = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != number1 && array[i] != number2) {
                return false;
            }
            if (array[i] == number1) {
                hasNumber1 = true;
            }
            if (array[i] == number2) {
                hasNumber2 = true;
            }
        }
        return hasNumber1 && hasNumber2;
    }
}
