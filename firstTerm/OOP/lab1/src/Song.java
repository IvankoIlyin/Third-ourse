public class Song {
    private String name;
    private double time;
    private String singer;
    private String style;

    Song(String name, double time, String singer, String style) {
        this.name = name;
        this.time = time;
        this.singer = singer;
        this.style = style;
    }

    public void printSong() {
        System.out.println(singer + "-" + name + "(" + time + ")" + " Style:" + style);
    }

    public double getTime() {
        return time;
    }

    public String getStyle(){
        return style;
    }

}
