import java.util.ArrayList;
import java.util.List;

public class Disk {
    private List<Song> songs;
    private int durationPlayList;

    Disk() {
        List<Song> songs = new ArrayList<Song>();
    }

    private void findDyration() {
        durationPlayList = 0;
        for (int i = 0; i < songs.size(); i++) {
            durationPlayList += songs.get(i).getTime();
        }
    }

    private void printPlayList() {
        for (int i = 0; i < songs.size(); i++) {
            songs.get(i).printSong();
        }
    }

    private List<Song> findByTime(double min, double max) {
        List<Song> current = new ArrayList<Song>();
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTime() >= min && songs.get(i).getTime() <= max) {
                current.add(songs.get(i));
            }
        }

        return current;
    }

    private void sortByStyle(){
        
    }


}
