import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class MyClientSocket {
    private static int port = 1488;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Enter command 'a' , 'b' , 'c' or 'x' to close ");
            String command=scan.nextLine();
            socket = new Socket(host.getHostName(), port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");
            if(command=="x"){
                socket = new Socket(host.getHostName(), port);
                oos = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("close");
                oos.writeChars(command); oos.flush();
                break;
            }

            switch (command){
                case "a":{
                    System.out.println("Enter author for search");
                    String author = scan.nextLine();
                    String message =""+command+"/"+author;
                    oos.writeChars(message);
                    oos.flush();
                    break;
                }
                case "b":{
                    System.out.println("Enter publishing house for search");
                    String publish_house = scan.nextLine();
                    String message =""+command+"/"+publish_house;
                    oos.writeChars(message);
                    oos.flush();
                    break;
                }
                case "c":{
                    System.out.println("Enter publishing year for search");
                    String publishing_year = scan.nextLine();
                    String message =""+command+"/"+publishing_year;
                    oos.writeChars(message);
                    oos.flush();
                    break;
                }
            }
            ois = new ObjectInputStream(socket.getInputStream());
            ArrayList<Book> res = (ArrayList<Book>) ois.readObject();
            System.out.println("Results: ");
            for (Book book: res)
            {
                book.print_book();
            }
            ois.close();
            oos.close();
            Thread.sleep(100);
        }
        oos.writeChars("x");
        System.out.println("Closing...");
    }
}
