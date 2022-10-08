
public class main {
    public static void main(String[] args) {
        Disk disk = new Disk();
        Blues b = new Blues("I Cant Quit You Baby", 5.27, "Otis Rush");
        disk.songs.add(b);
        b = new Blues("I’d Rather Go Blind", 7.03, "Etta James");
        disk.songs.add(b);
        b = new Blues("Crossroad Blues", 2.38, "Robert Johnson");
        disk.songs.add(b);
        b = new Blues("Pride And Joy", 4.02, "Stevie Ray Vaughan");
        disk.songs.add(b);
        b = new Blues("I’m Tore Down", 2.39, "Freddy King");
        disk.songs.add(b);

        Rock r = new Rock("BOHEMIAN RHAPSODY", 6.0, "QUEEN");
        disk.songs.add(r);
        r = new Rock("FREE BIRD", 3.15, "LYNYRD SKYNYRD");
        disk.songs.add(r);
        r = new Rock("SMOKE ON THE WATER", 4.20, "DEEP PURPLE");
        disk.songs.add(r);
        r = new Rock("COMFORTABLY NUMB", 2.34, "PINK FLOYD");
        disk.songs.add(r);
        r = new Rock("KASHMIR", 3.24, "LED ZEPPELIN");
        disk.songs.add(r);

        Hiphop h = new Hiphop("Mind Playing Tricks on Me", 5.05, "Geto Boys");
        disk.songs.add(h);
        h = new Hiphop("Nuthin’ but a ‘G’ Thang", 4.46, "Dr. Dre feat. Snoop Doggy Dogg");
        disk.songs.add(h);
        h = new Hiphop("Fight the Power", 5.21, "Public Enemy");
        disk.songs.add(h);
        h = new Hiphop("Juicy", 4.12, "The Notorious B.I.G.");
        disk.songs.add(h);
        h = new Hiphop("Fuck Tha Police", 5.45, "N.W.A");
        disk.songs.add(h);

        Reggae reg = new Reggae("Pressure Drop", 3.44, "Toots and the Maytals");
        disk.songs.add(reg);
        reg = new Reggae("Red Red Wine", 3.24, "UB40");
        disk.songs.add(reg);
        reg = new Reggae("One Love", 2.45, "Bob Marley");
        disk.songs.add(reg);
        reg = new Reggae("Many Rivers To Cross", 3.56, "Jimmy Cliff");
        disk.songs.add(reg);
        reg = new Reggae("Bam Bam", 3.17, "Sister Nancy");
        disk.songs.add(reg);

        LoFi l = new LoFi("champagne cola", 2.27, "chuckee.");
        disk.songs.add(l);
        l = new LoFi("Ergo", 2.06, "Birocratic");
        disk.songs.add(l);
        l = new LoFi("french inhale", 1.48, "bsd.u");
        disk.songs.add(l);
        l = new LoFi("emune", 2.19, "Tummy (Instrumental)");
        disk.songs.add(l);
        l = new LoFi("Winter sunset", 2.13, "Mt Fujitive");
        disk.songs.add(l);


        disk.printPlayList();


    }
}
