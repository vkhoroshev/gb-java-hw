package quarter01.level02.lesson03;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        /**
         * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
         * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
         * Посчитать сколько раз встречается каждое слово.
         */
        String[] words = getArrayWords();
        System.out.println(Arrays.toString(words));

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
    }

    private static String[] getArrayWords() {
        return new String[]{
                "Human",
                "Elf",
                "Goblin",
                "Dwarf",
                "Orc",
                "Goblin",
                "Elf",
                "Human",
                "Orc",
                "Goblin",
                "Human",
                "Dwarf",
                "Orc",
                "Human",
                "Goblin",
                "Elf",
                "Goblin",
                "Orc",};
    }
}
