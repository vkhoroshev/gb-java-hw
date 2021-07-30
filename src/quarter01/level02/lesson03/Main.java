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
        System.out.println();

        /**
         * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
         * В этот телефонный справочник с помощью метода add() можно добавлять записи.
         * С помощью метода get() искать номер телефона по фамилии.
         * Следует учесть, что под одной фамилией может быть несколько телефонов,
         * тогда при запросе такой фамилии должны выводиться все телефоны.
         */
        Phonebook phonebook = new Phonebook();
        phonebook.add("Human1", "89008001001");
        phonebook.add("Human2", "89008001002");
        phonebook.add("Human3", "89008001003");
        phonebook.add("Human1", "89008001004");
        phonebook.add("Human4", "89008001005");
        phonebook.add("Human2", "89008001006");
        phonebook.add("Human1", "89008001007");
        phonebook.add("Human3", "89008001008");

        System.out.println("Human1 phones: " + phonebook.get("Human1"));
        System.out.println("Human2 phones: " + phonebook.get("Human2"));
        System.out.println("Human3 phones: " + phonebook.get("Human3"));
        System.out.println("Human4 phones: " + phonebook.get("Human4"));
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
