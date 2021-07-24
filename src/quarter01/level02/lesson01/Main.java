package quarter01.level02.lesson01;

public class Main {
    public static void main(String[] args) {
        Sportsman[] sportsmens = {
                new Human(100, 15),
                new Cat(80, 20),
                new Robot(1000, 300)
        };

        SportsEvent[] sportsEvents = {
                new RunningTrack(90),
                new Wall(17)
        };

        for (Sportsman sportsmen : sportsmens) {
            for (SportsEvent sportsEvent : sportsEvents) {
                if (!sportsEvent.overcomeObstacle(sportsmen)) {
                    break;
                }
            }
        }
    }
}
