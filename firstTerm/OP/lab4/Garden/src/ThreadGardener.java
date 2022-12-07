import java.util.concurrent.locks.ReentrantLock;

public class ThreadGardener extends Thread {
    ReentrantLock rtLock;
    Garden garden;

    ThreadGardener(ReentrantLock rtLock, Garden garden) {
        this.rtLock = rtLock;
        this.garden = garden;
    }

    @Override
    public void run() {
        while (true) {
            rtLock.lock();
            try {
                for (int i = 0; i < garden.field.length; i++) {
                    for (int j = 0; j < garden.field.length; j++) {
                        garden.ChangePlantStatus(i, j, 1);
                    }
                }
            } finally {
                rtLock.unlock();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
