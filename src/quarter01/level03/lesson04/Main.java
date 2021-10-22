package quarter01.level03.lesson04;

public class Main {
    static final Object monitor = new Object();
    static volatile char currentLetter = 'A';

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 'A') {
                            monitor.wait();
                        }
                        System.out.print("A");
                        currentLetter = 'B';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 'B') {
                            monitor.wait();
                        }
                        System.out.print("B");
                        currentLetter = 'C';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 'C') {
                            monitor.wait();
                        }
                        System.out.print("C");
                        currentLetter = 'A';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
