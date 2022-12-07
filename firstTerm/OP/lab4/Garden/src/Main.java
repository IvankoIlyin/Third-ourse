import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock rtLock = new ReentrantLock();
        Garden garden = new Garden();
        garden.PrintGarden();

        ThreadWaster threadWaster = new ThreadWaster(rtLock, garden);
        threadWaster.start();
        ThreadPrint threadPrinter = new ThreadPrint(rtLock, garden);
        threadPrinter.start();
        ThreadGardener threadRainer = new ThreadGardener(rtLock, garden);
        threadRainer.start();
        ThreadFilewriter threadFilewriter = new ThreadFilewriter(rtLock, garden, "./src/output.txt");
        threadFilewriter.start();
    }
}