import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface RMIServer extends Remote {
    List<Book> search_by_author(String author);
    List<Book> search_by_publish_house(String publish_house);
    List<Book> search_by_publish_year(String publish_year);
}

public class MyRMIServer {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1488);
        RMIServer service = new Service();
        registry.rebind("EXAM", service);
        System.out.println("Server started");
    }

    static class Service extends  UnicastRemoteObject implements RMIServer {
        List<Book> books = new ArrayList<>();
        Service() throws RemoteException {
            super();
            books.add(new Book(0,"Koran","Muhamed","IslamHouse",2000,505,228,"Hardcover"));
            books.add(new Book(1,"Bible","Jesus","ChristianHouse",2005,666,133,"Hardcover"));
            books.add(new Book(2,"The Lion, the Witch and the Wardrobe","C. S. Lewis","Geoffrey Bles",1950,200,300,"Softcover"));
            books.add(new Book(3,"Prince Caspian: The Return to Narnia","C. S. Lewis","Geoffrey Bles",1951,340,300,"Softcover"));
            books.add(new Book(4,"The Horse and His Boy","C. S. Lewis","The Bodley Head",1954,200,300,"Softcover"));
            books.add(new Book(5,"The Call of Cthulhu"," H. P. Lovecraft","Weird Tales",1928,450,500,"Hardcover"));
            books.add(new Book(5,"The Dunwich Horror"," H. P. Lovecraft","Weird Tales",1929,550,360,"Hardcover"));
            books.add(new Book(6,"The Colour Out of Space"," H. P. Lovecraft","Weird Tales", 1927,730,420,"Hardcover"));
        }

        @Override
        public List<Book> search_by_author(String author) {
            List<Book> res = new ArrayList<>();
            for(Book book:books){
                if(book.get_author()==author){res.add(book);}
            }
            return res;
        }

        @Override
        public List<Book> search_by_publish_house(String publish_house) {
            List<Book> res = new ArrayList<>();
            for(Book book:books){
                if(book.get_publish_house()==publish_house){res.add(book);}
            }
            return res;
        }

        @Override
        public List<Book> search_by_publish_year(String publish_year) {
            List<Book> res = new ArrayList<>();
            int p_y = Integer.parseInt(publish_year);
            for(Book book:books){
                if(book.get_publish_year()>=p_y){res.add(book); book.print_book();}
            }
            return res;
        }
    }

}
