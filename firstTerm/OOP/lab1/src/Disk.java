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

    public List<Song> printPlayList() {
        for (int i = 0; i < songs.size(); i++) {
            songs.get(i).printSong(disk);
        }
        calculateDuration();
        String dur=String.format("%.3f",durationPlayList);
        System.out.println("Duration of playlist: "+ dur);
        JSONObject duration = new JSONObject();
        duration.put("Duration:", durationPlayList);
        disk.add(duration);

        try (FileWriter file = new FileWriter(path)) {
            file.write(disk.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }
    public double calculateDuration(){
        durationPlayList = 0;
        for (int i = 0; i < songs.size(); i++) {
            durationPlayList += songs.get(i).getTime();
        }
        return durationPlayList;
    }
    public List<Song> printFindingByTime(double min, double max) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTime() >= min && songs.get(i).getTime() <= max) {
                byTime.add(songs.get(i));
            }
        }
        System.out.println("---------Songs between "+min+" and "+max+"---------");
        for (int i = 0; i < byTime.size(); i++) {
            byTime.get(i).printSong(disk);
        }
        try (FileWriter file = new FileWriter(path)) {
            file.write(disk.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byTime;
    }
    public void sortByStyle() {
        songs.sort((a, b) -> a.getStyle().compareTo(b.getStyle()));
    }




}
