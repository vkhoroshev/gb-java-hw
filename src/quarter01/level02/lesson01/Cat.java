package quarter01.level02.lesson01;

public class Cat implements Sportsman {
    private final int maxRun;
    private final int maxJump;

    public Cat(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRun) {
            System.out.println("Кот пробежал " + distance + "м.");
            return true;
        } else {
            System.out.println("Кот не смог пробежать " + distance + "м.");
            return false;
        }
    }

    @Override
    public boolean jump(int distance) {
        if (distance <= maxJump) {
            System.out.println("Кот перепрыгнул " + distance + "м.");
            return true;
        } else {
            System.out.println("Кот не смог перепрыгнуть " + distance + "м.");
            return false;
        }
    }
}
