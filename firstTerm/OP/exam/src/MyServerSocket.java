import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Callback {
    public boolean shouldEnd = false;
}


class BookIterator implements Runnable{
    private Socket socket;
    private Callback callback;
    private List<Book> books;

    public BookIterator(Socket socket,Callback callback,List<Book> books){
        this.socket=socket;
        this.callback=callback;
        this.books=books;
    }

    @Override
    public void run() {
        try{
            InputStreamReader ois = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(ois);
            String message = reader.readLine();
            String splitMessage[] = message.split("/");
            String command = splitMessage[0];
            System.out.println(splitMessage[0]+" "+splitMessage[1]);

            if(command=="x"){
                System.out.println("Close...");
                callback.shouldEnd = true;
                return;
            }

            List<Book> res = new ArrayList<>();
            switch (command){
                case "a":{
                    String author = splitMessage[1];
                    for(Book book:books){
                        if(book.get_author()==author){res.add(book);}
                    }
                    break;
                }
                case "b":{
                    String publish_house = splitMessage[1];
                    for(Book book:books){
                        if(book.get_publish_house()==publish_house){res.add(book);}
                    }
                    break;
                }
                case "c":{
                    String publishing_year = splitMessage[1];
                    int p_y = Integer.parseInt(publishing_year);
                    for(Book book:books){
                        if(book.get_publish_year()>=p_y){res.add(book); book.print_book();}
                    }
                    break;
                }
            }

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(res);
            ois.close();
            oos.close();
            socket.close();

        }
        catch (IOException e) { }
    }

}


public class MyServerSocket {
    private static ServerSocket server;
    private static int port = 1488;
    public static Callback c = new Callback();

    public static void main(String args[]) throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);
        List<Book> books = new ArrayList<>();
        books.add(new Book(0,"Koran","Muhamed","IslamHouse",2000,505,228,"Hardcover"));
        books.add(new Book(1,"Bible","Jesus","ChristianHouse",2005,666,133,"Hardcover"));
        books.add(new Book(2,"The Lion, the Witch and the Wardrobe","C. S. Lewis","Geoffrey Bles",1950,200,300,"Softcover"));
        books.add(new Book(3,"Prince Caspian: The Return to Narnia","C. S. Lewis","Geoffrey Bles",1951,340,300,"Softcover"));
        books.add(new Book(4,"The Horse and His Boy","C. S. Lewis","The Bodley Head",1954,200,300,"Softcover"));
        books.add(new Book(5,"The Call of Cthulhu"," H. P. Lovecraft","Weird Tales",1928,450,500,"Hardcover"));
        books.add(new Book(5,"The Dunwich Horror"," H. P. Lovecraft","Weird Tales",1929,550,360,"Hardcover"));
        books.add(new Book(6,"The Colour Out of Space"," H. P. Lovecraft","Weird Tales", 1927,730,420,"Hardcover"));

        while(!c.shouldEnd){
            System.out.println("Listening...");
            Socket socket = server.accept();
            BookIterator iterator = new BookIterator(socket, c, books);
            iterator.run();
        }
        System.out.println("Shutting down Socket server!!");
        server.close();

    }

}
