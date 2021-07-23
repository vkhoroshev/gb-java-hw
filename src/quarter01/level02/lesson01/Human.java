package quarter01.level02.lesson01;

public class Human implements Sportsman {
    private final int maxRun;
    private final int maxJump;

    public Human(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRun) {
            System.out.println("Человек пробежал " + distance + "м.");
            return true;
        } else {
            System.out.println("Человек не смог пробежать " + distance + "м.");
            return false;
        }
    }

    @Override
    public boolean jump(int distance) {
        if (distance <= maxJump) {
            System.out.println("Человек перепрыгнул " + distance + "м.");
            return true;
        } else {
            System.out.println("Человек не смог перепрыгнуть " + distance + "м.");
            return false;
        }
    }
}
