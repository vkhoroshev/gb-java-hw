package quarter01.level02.lesson05;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        float[] array = new float[SIZE];

        methodOne(array);
        methodTwo(array);
    }

    public static void methodOne(float[] array) {
        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Method one: " + (endTime - startTime) + " ms");
    }

    public static void methodTwo(float[] array) {
        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();

        float[] arrayOne = new float[HALF];
        float[] arrayTwo = new float[HALF];
        System.arraycopy(array, 0, arrayOne, 0, HALF);
        System.arraycopy(array, HALF, arrayTwo, 0, HALF);

        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < arrayOne.length; i++) {
                arrayOne[i] = (float) (arrayOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < arrayTwo.length; i++) {
                arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i + HALF) / 5) * Math.cos(0.4f + (i + HALF) / 2));
            }
        });

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrayOne, 0, array, 0, HALF);
        System.arraycopy(arrayTwo, 0, array, HALF, HALF);

        long endTime = System.currentTimeMillis();
        System.out.println("Method two: " + (endTime - startTime) + " ms");
    }
}
