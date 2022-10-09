import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;




@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DiskTest2 {
    private Disk disk = new Disk();

    @BeforeAll
    void setup(){
        LoFi l = new LoFi("champagne cola", 2.27, "chuckee.");
        disk.songs.add(l);
        l = new LoFi("Ergo", 2.06, "Birocratic");
        disk.songs.add(l);
        l = new LoFi("french inhale", 1.48, "bsd.u");
        disk.songs.add(l);
        Reggae reg = new Reggae("Pressure Drop", 3.44, "Toots and the Maytals");
        disk.songs.add(reg);
        reg = new Reggae("Red Red Wine", 3.24, "UB40");
        disk.songs.add(reg);
        Hiphop h = new Hiphop("Mind Playing Tricks on Me", 5.05, "Geto Boys");
        disk.songs.add(h);
        h = new Hiphop("Juicy", 4.12, "The Notorious B.I.G.");
        disk.songs.add(h);
        h = new Hiphop("Fuck Tha Police", 5.45, "N.W.A");
        disk.songs.add(h);
    }

    @Test
    void calculateDuration() {
        double testDuration = disk.calculateDuration();
        assertEquals(testDuration,27.11);
    }

    @Test
    void printFindingByTime() {
        List<Song> test = new ArrayList<Song>();
        test=disk.printFindingByTime(1.0,2.0);
        assertTrue(test.get(0).getTime()==1.48);
    }

    @Test
    void sortByStyle() {
        disk.sortByStyle();
        List<Song> test = new ArrayList<Song>();
        test=disk.printPlayList();
        int check=0;
        for(int i=0;i<test.size()-1;i++){
            if(test.get(i).getStyle().compareTo(test.get(i+1).getStyle())>0){check+=1;}
        }
        assertEquals(check,0);
    }
    }
