import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadWaster extends Thread {
    ReentrantLock rtLock;
    Garden garden;

    ThreadWaster(ReentrantLock rtLock, Garden garden) {
        this.rtLock = rtLock;
        this.garden = garden;
    }

    @Override
    public void run() {
        while (true) {
            rtLock.lock();
            try {
                int randX = ThreadLocalRandom.current().nextInt(0, 9);
                int randY = ThreadLocalRandom.current().nextInt(0, 9);
                garden.ChangePlantStatus(randX, randY, 0);
            } finally {
                rtLock.unlock();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
