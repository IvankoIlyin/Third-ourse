import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        List<String[]> db = new ArrayList<String[]>();
        main.ScanFileInList2D(db);
        ReadWriteLock myLock = new ReadWriteLock();
        List<Th1> threadList = new ArrayList<Th1>();
        threadList.add(new Th1(myLock, db, "John"));
        threadList.add(new Th1(myLock, db, "Irvin"));
        threadList.add(new Th1(myLock, db, "Doe"));
        for (var i : threadList) {
            i.start();
        }
    }

    private static void ScanFileInList2D(List<String[]> list) {
        try {
            File myObj = new File("./src/out.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String arr[] = data.split(" ");
                list.add(arr);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

class ReadWriteLock{

    private int readers       = 0;
    private int writers       = 0;
    private int writeRequests = 0;

    public synchronized void lockRead() throws InterruptedException{
        while(writers > 0 || writeRequests > 0 || readers > 0){
            wait();
        }
        readers++;
    }

    public synchronized void unlockRead(){
        readers--;
        notifyAll();
    }
}

class Th1 extends Thread {
    static ReadWriteLock myLock;
    List<String[]> db;
    String param;

    Th1(ReadWriteLock myLock, List<String[]> db, String param) {
        this.myLock = myLock;
        this.db = db;
        this.param = param;
    }

    @Override
    public void run() {
        while (true) {
            try {
                myLock.lockRead();
                for (String[] it : db) {
                    for (String i : it) {
                        if (i.equals(param)) {
                            System.out.print(this.getId() + " ");
                            for (String j : it) {
                                System.out.print(j + " ");
                            }
                            System.out.println();
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                System.out.println(getId() + " Finished!");
                myLock.unlockRead();
            }
        }
    }
}