
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.FileWriter;
import java.io.IOException;

public class Song {
    private String name;
    private double time;
    private String singer;
    private String style;
    private String path = "./src/disk.json";

    Song(String name, double time, String singer, String style) {
        this.name = name;
        this.time = time;
        this.singer = singer;
        this.style = style;
    }

    public void printSong(JSONArray disk) {
        System.out.println(singer + "-" + name + "(" + time + ")" + " Style:" + style);
        JSONObject song = new JSONObject();
        song.put("Singer", singer);
        song.put("Name", name);
        song.put("Time", time);
        song.put("Style", style);
        disk.add(song);
    }

    public String getName(){return name;}
    public double getTime() {
        return time;
    }

    public String getStyle() {
        return style;
    }

}
