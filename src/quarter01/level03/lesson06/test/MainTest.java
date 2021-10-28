package quarter01.level03.lesson06.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import quarter01.level03.lesson06.main.Main;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // @Test arrayAfterNumber()

    @Test
    void arrayAfterNumber1() {
        int[] input = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] output = new int[]{1, 7};
        Assertions.assertArrayEquals(output, Main.arrayAfterNumber(input, 4));
    }

    @Test
    void arrayAfterNumber2() {
        int[] input = new int[]{1, 2, 4, 4, 2, 3, 4};
        int[] output = new int[]{};
        Assertions.assertArrayEquals(output, Main.arrayAfterNumber(input, 4));
    }

    @Test
    void arrayAfterNumber3() {
        int[] input = new int[]{1, 2};
        Assertions.assertThrows(RuntimeException.class, () -> {
            Main.arrayAfterNumber(input, 4);
        });
    }

    @Test
    void arrayAfterNumber4() {
        int[] input = new int[]{1, 2, 4, 4, 2, 3, 1, 7};
        int[] output = new int[]{2, 3, 1, 7};
        Assertions.assertArrayEquals(output, Main.arrayAfterNumber(input, 4));
    }

    // @Test arrayContainsOnlyTheseNumbers()

    @Test
    void arrayContainsOnlyTheseNumbers1() {
        int[] input = new int[]{1, 1, 1, 4, 4, 1, 4, 4};
        Assertions.assertTrue(Main.arrayContainsOnlyTheseNumbers(input, 1, 4));
    }

    @Test
    void arrayContainsOnlyTheseNumbers2() {
        int[] input = new int[]{1, 1, 1, 1, 1, 1};
        Assertions.assertFalse(Main.arrayContainsOnlyTheseNumbers(input, 1, 4));
    }

    @Test
    void arrayContainsOnlyTheseNumbers3() {
        int[] input = new int[]{4, 4, 4, 4};
        Assertions.assertFalse(Main.arrayContainsOnlyTheseNumbers(input, 1, 4));
    }

    @Test
    void arrayContainsOnlyTheseNumbers4() {
        int[] input = new int[]{1, 4, 4, 8, 1, 1, 4, 3};
        Assertions.assertFalse(Main.arrayContainsOnlyTheseNumbers(input, 1, 4));
    }
}
