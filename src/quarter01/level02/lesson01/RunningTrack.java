package quarter01.level02.lesson01;

public class RunningTrack implements SportsEvent {
    private final int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcomeObstacle(Sportsman sportsman) {
        return sportsman.run(distance);
    }
}
