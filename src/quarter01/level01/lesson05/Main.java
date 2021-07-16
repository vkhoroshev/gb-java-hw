package quarter01.level01.lesson05;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Ivan 1", "Develop 1", "dev1@mailbox.com", "89008001001", 11_000, 21);
        persons[1] = new Person("Ivan 2", "Develop 2", "dev2@mailbox.com", "89008001002", 12_000, 42);
        persons[2] = new Person("Ivan 3", "Develop 3", "dev3@mailbox.com", "89008001003", 13_000, 23);
        persons[3] = new Person("Ivan 4", "Develop 4", "dev4@mailbox.com", "89008001004", 14_000, 44);
        persons[4] = new Person("Ivan 5", "Develop 5", "dev5@mailbox.com", "89008001005", 15_000, 25);

        for (Person person : persons) {
            if (person.getAge() > 40) {
                person.printInfo();
            }
        }
    }
}
