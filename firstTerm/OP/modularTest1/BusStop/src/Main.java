import java.util.concurrent.Semaphore;

public class Main {
    private static int count = 3;
    private static int place = 1;
    private static final Semaphore SEMAPHORE = new Semaphore(place, true);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            new Thread(new Bus()).start();
            Thread.sleep(1000);
        }
    }

    public static class Bus extends Thread {
        @Override
        public void run() {
            try {
                SEMAPHORE.acquire();
                System.out.println("Bus arrived to station");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new Error();
            }
            SEMAPHORE.release();
            System.out.printf("Bus leave from station");
        }
    }
}