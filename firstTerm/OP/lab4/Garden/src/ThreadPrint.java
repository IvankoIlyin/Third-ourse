import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint extends Thread {
    ReentrantLock rtLock;
    Garden garden;

    ThreadPrint(ReentrantLock rtLock, Garden garden) {
        this.rtLock = rtLock;
        this.garden = garden;
    }

    @Override
    public void run() {
        while (true) {
            rtLock.lock();
            try {
                garden.PrintGarden();
            } finally {
                rtLock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
