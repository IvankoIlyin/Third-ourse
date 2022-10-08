import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class Disk {
    public List<Song> songs = new ArrayList<Song>();
    private List<Song> byTime = new ArrayList<Song>();
    private double durationPlayList;
    private JSONArray disk = new JSONArray();
    private String path = "./src/disk.json";

    public void printPlayList() {
        for (int i = 0; i < songs.size(); i++) {
            songs.get(i).printSong(disk);
        }
        durationPlayList = 0;
        for (int i = 0; i < songs.size(); i++) {
            durationPlayList += songs.get(i).getTime();
        }
        System.out.println("Duration of Playlist: " + durationPlayList);
        JSONObject duration = new JSONObject();
        duration.put("Duration:", durationPlayList);
        disk.add(duration);

        try (FileWriter file = new FileWriter(path)) {
            file.write(disk.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFindingByTime(double min, double max) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTime() >= min && songs.get(i).getTime() <= max) {
                byTime.add(songs.get(i));
            }
        }
        for (int i = 0; i < byTime.size(); i++) {
            byTime.get(i).printSong(disk);
        }
        try (FileWriter file = new FileWriter(path)) {
            file.write(disk.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sortByStyle() {
        songs.sort((a, b) -> a.getStyle().compareTo(b.getStyle()));
    }


}
