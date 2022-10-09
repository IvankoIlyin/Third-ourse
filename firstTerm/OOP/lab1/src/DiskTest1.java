import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DiskTest1 {

    private Disk disk = new Disk();

    @BeforeAll
    void setup(){
        Blues b = new Blues("I Cant Quit You Baby", 5.27, "Otis Rush");
        disk.songs.add(b);
        b = new Blues("I’d Rather Go Blind", 7.03, "Etta James");
        disk.songs.add(b);
        Rock r = new Rock("BOHEMIAN RHAPSODY", 6.0, "QUEEN");
        disk.songs.add(r);
        r = new Rock("FREE BIRD", 3.15, "LYNYRD SKYNYRD");
        disk.songs.add(r);
        Hiphop h = new Hiphop("Mind Playing Tricks on Me", 5.05, "Geto Boys");
        disk.songs.add(h);
        h = new Hiphop("Nuthin’ but a ‘G’ Thang", 4.46, "Dr. Dre feat. Snoop Doggy Dogg");
        disk.songs.add(h);
    }


    @Test
    void calculateDuration() {
        double testDuration = disk.calculateDuration();
        assertEquals(testDuration,30.96);
    }

    @Test
    void printFindingByTime() {
        List<Song> test = new ArrayList<Song>();
        test=disk.printFindingByTime(3.0,3.30);
        assertTrue(test.get(0).getTime()==3.15);
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