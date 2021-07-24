package quarter01.level02.lesson01;

public class Wall implements SportsEvent {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcomeObstacle(Sportsman sportsman) {
        return sportsman.jump(height);
    }
}
