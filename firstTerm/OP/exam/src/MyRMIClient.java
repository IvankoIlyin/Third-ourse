import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class MyRMIClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String command = "x";
        Scanner in = new Scanner(System.in);
        try{
            RMIServer st = (RMIServer) Naming.lookup("//localhost:1488/EXAM");
            System.out.println("Enter command 'a' , 'b' , 'c' or 'x' to close ");
            command = in.nextLine();
            switch (command){
                case "a":{
                    System.out.println("Enter author for search");
                    String author = in.nextLine();
                    for (Book book: st.search_by_author(author))
                    {
                        book.print_book();
                    }
                    break;
                }
                case "b":{
                    System.out.println("Enter publishing house for search");
                    String publish_house = in.nextLine();
                    for (Book book: st.search_by_author(publish_house))
                    {
                        book.print_book();
                    }
                    break;
                }
                case "c":{
                    System.out.println("Enter publishing year for search");
                    String publishing_year = in.nextLine();
                    for (Book book: st.search_by_author(publishing_year))
                    {
                        book.print_book();
                    }
                    break;
                }
            }

        }
        catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
