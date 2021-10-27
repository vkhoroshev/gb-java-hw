package quarter01.level03.lesson05;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static AtomicInteger ai;
    private static int CARS_COUNT;

    static {
        ai = new AtomicInteger(0);
    }

    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier barrier;

    public Car(Race race, int speed, CyclicBarrier barrier) {
        CARS_COUNT++;
        this.race = race;
        this.speed = speed;
        this.name = "Участник #" + CARS_COUNT;
        this.barrier = barrier;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
            barrier.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            if (ai.incrementAndGet() == 1) {
                System.out.println(name + " ПОБЕДИЛ !!!");
            }

            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
