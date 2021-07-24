package quarter01.level02.lesson01;

public class Robot implements Sportsman {
    private final int maxRun;
    private final int maxJump;

    public Robot(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= maxRun) {
            System.out.println("Робот пробежал " + distance + "м.");
            return true;
        } else {
            System.out.println("Робот не смог пробежать " + distance + "м.");
            return false;
        }
    }

    @Override
    public boolean jump(int distance) {
        if (distance <= maxJump) {
            System.out.println("Робот перепрыгнул " + distance + "м.");
            return true;
        } else {
            System.out.println("Робот не смог перепрыгнуть " + distance + "м.");
            return false;
        }
    }
}
