package quarter.one.level.one.lesson.six;

public class Animal {
    String name;
    String type;
    int maxRunDistance;
    int maxSwimDistance;

    public Animal(String name, String type, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.type = type;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    public void run(int distance) {
        if (maxRunDistance == 0) {
            System.out.printf("%s '%s' - не умеет бегать.", type, name);
            return;
        }
        if (distance < 0) {
            System.out.println("Для бега необходимо ввести неотрицательное число!");
            return;
        }
        if (distance <= maxRunDistance) {
            System.out.printf("%s '%s' пробежал(а) %d метров.\n", type, name, distance);
        } else {
            System.out.printf("%s '%s' не сможет пробежать %d метров.\n", type, name, distance);
        }
    }

    public void swim(int distance) {
        if (maxRunDistance == 0) {
            System.out.printf("%s '%s' - не умеет плавать.", type, name);
            return;
        }
        if (distance < 0) {
            System.out.println("Для плавания необходимо ввести неотрицательное число!");
            return;
        }
        if (distance <= maxRunDistance) {
            System.out.printf("%s '%s' проплыл(а) %d метров.\n", type, name, distance);
        } else {
            System.out.printf("%s '%s' не сможет проплыть %d метров.\n", type, name, distance);
        }
    }
}
