import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DiskTest3 {
    private Disk disk = new Disk();

    @BeforeAll
    void setup(){
        Blues b = new Blues("I Cant Quit You Baby", 5.27, "Otis Rush");
        disk.songs.add(b);
        b = new Blues("I’d Rather Go Blind", 7.03, "Etta James");
        disk.songs.add(b);
        Reggae reg = new Reggae("Pressure Drop", 3.44, "Toots and the Maytals");
        disk.songs.add(reg);
        reg = new Reggae("Red Red Wine", 3.24, "UB40");
        disk.songs.add(reg);
    }


    @Test
    void calculateDuration() {
        double testDuration = disk.calculateDuration();
        assertEquals(testDuration,18.98);
    }

    @Test
    void printFindingByTime() {
        List<Song> test = new ArrayList<Song>();
        test=disk.printFindingByTime(7.0,8.0);
        assertTrue(test.get(0).getTime()==7.03);
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
