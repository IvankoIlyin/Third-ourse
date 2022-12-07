import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadFilewriter extends Thread{
    ReentrantLock rtLock;
    Garden garden;
    String filename;

    ThreadFilewriter(ReentrantLock rtLock, Garden garden, String filename) {
        this.rtLock = rtLock;
        this.garden = garden;
        this.filename = filename;
    }

    @Override
    public void run() {
        while (true) {
            rtLock.lock();
            try {
                FileWriter fw = null;
                try {
                    fw = new FileWriter(filename, true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                PrintWriter writer = new PrintWriter(fw);
                System.out.println("File Write");

                for (int i = 0; i < garden.field.length; i++) {

                    byte[] strToBytes = Arrays.toString(garden.field[i]).getBytes();
                    writer.print(Arrays.toString(garden.field[i]));
                    writer.println();
                }
                writer.println();
                writer.close();
            }
            finally {
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
