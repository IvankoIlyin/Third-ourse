import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Disk {
    public List<Song> songs = new ArrayList<Song>();
    private List<Song> byTime = new ArrayList<Song>();
    public int durationPlayList;

    public void findDyration() {
        durationPlayList = 0;
        for (int i = 0; i < songs.size(); i++) {
            durationPlayList += songs.get(i).getTime();
        }
    }
    public void printPlayList() {
        for (int i = 0; i < songs.size(); i++) {
            songs.get(i).printSong();
        }
    }
    public void printFindingByTime(){
        for (int i = 0; i < byTime.size(); i++) {
            byTime.get(i).printSong();
        }
    }
    public void findByTime(double min, double max) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTime() >= min && songs.get(i).getTime() <= max) {
                byTime.add(songs.get(i));
            }
        }
    }
    public void sortByStyle(){
        songs.sort((a,b) -> a.getStyle().compareTo(b.getStyle()));
    }


}
