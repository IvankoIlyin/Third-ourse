import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;


public class WinnieThePooh {
    private JFrame win;
    private Bee bee1,bee2,bee3,bee4,bee5,bee6,bee7,bee8,bee9;
    public Winnie winnie;
    private int size = 15;

    public boolean winnieDied, synhro;

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    WinnieThePooh(int w, int h){
        win = new JFrame("Lab1");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(w,h);
        win.getContentPane().setBackground(new Color(52,138,55));
        win.setLayout(null);
        bee1 = new Bee((w/3-w/size)/2,(h/3-h/size)/2,w/size,"bee1",(w/3-w/size)/2,(h/3-h/size)/2);
        bee2 = new Bee(w/3+(w/3-w/size)/2,(h/3-h/size)/2,w/size,"bee2",w/3+(w/3-w/size)/2,(h/3-h/size)/2);
        bee3 = new Bee(2*w/3+(w/3-w/size)/2,(h/3-h/size)/2,w/size,"bee3",2*w/3+(w/3-w/size)/2,(h/3-h/size)/2);
        bee4 = new Bee((w/3-w/size)/2,h/3+((h/3-h/size)/2),w/size,"bee4",(w/3-w/size)/2,h/3+((h/3-h/size)/2));
        bee5 = new Bee(w/3+(w/3-w/size)/2,h/3+((h/3-h/size)/2),w/size,"bee5",w/3+(w/3-w/size)/2,h/3+((h/3-h/size)/2));
        bee6 = new Bee(2*w/3+(w/3-w/size)/2,h/3+((h/3-h/size)/2),w/size,"bee6",2*w/3+(w/3-w/size)/2,h/3+((h/3-h/size)/2));
        bee7 = new Bee((w/3-w/size)/2,2*h/3+(h/3-h/size)/2,w/size,"bee7",(w/3-w/size)/2,2*h/3+(h/3-h/size)/2);
        bee8 = new Bee(w/3+(w/3-w/size)/2,2*h/3+(h/3-h/size)/2,w/size,"bee8",w/3+(w/3-w/size)/2,2*h/3+(h/3-h/size)/2);
        bee9 = new Bee(2*w/3+(w/3-w/size)/2,2*h/3+(h/3-h/size)/2,w/size,"bee9",2*w/3+(w/3-w/size)/2,2*h/3+(h/3-h/size)/2);
        int winnieChecPointx = getRandomNumberInRange(0,w);
        int winnieChecPointy = getRandomNumberInRange(0,h);
        while(winnieChecPointx>w || winnieChecPointy>h){
            winnieChecPointx = getRandomNumberInRange(0,w);
            winnieChecPointy = getRandomNumberInRange(0,h);
        }
        winnie = new Winnie(winnieChecPointx,winnieChecPointy,w/size,"winnie", w, h);
        Bee[] bees = {bee1,bee2,bee3,bee4,bee5,bee6,bee7,bee8,bee9};
        for(int i=0; i<bees.length;i++){
            win.add(bees[i].body);
        }
        win.add(winnie.body);
        win.setVisible(true);
        winnieDied = false;
        BeeGoToKill();

    }


    private void BeeGoToKill(){
        Bee[] bees = {bee1,bee2,bee3,bee4,bee5,bee6,bee7,bee8,bee9};
        for(int i=0; i<bees.length;i++){
            bees[i].start();
            bees[i].setPriority(1);
        }
        winnie.start();
        winnie.setPriority(2);
    }


    class Bee extends Thread{
        private int x,y,w,h,size;
        String name;
        private JPanel body = new JPanel();

        private double r ;

        public Bee(int x, int y, int size, String name,int w,int h){
            this.x = x;
            this.y = y;
            this.size = size;
            this.name = name;
            this.w = w;
            this.h = h;
            body.setBackground(Color.yellow);
            body.setBounds(x,y,size,size);
            body.setLayout(null);
            body.setVisible(true);
            r= Math.sqrt(2)*size;
        }

        private static int getRandomNumberInRange(int min, int max) {

            if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
            }

            Random r = new Random();
            return r.nextInt((max - min) + 1) + min;
        }


        @Override
        public void run(){
            while (winnieDied==false) {
                int changeH = Math.round(h / 6);
                int changeW = Math.round(w / 6);
                if(x+changeW>w || y>h+changeH){
                    changeH = Math.round(h/6);
                    changeW = Math.round(w/6);
                }
                body.setBounds(x + getRandomNumberInRange(-1*changeW, changeW), y + getRandomNumberInRange(-1*changeH, changeH), size, size);
                double x2 = winnie.x;
                double y2 = winnie.y;
                if(Math.sqrt((x-x2)*(x-x2)+(y-y2)*(y-y2))<=winnie.r+10){
                    winnieDied=true;
                }
                double a = winnie.r+10;
                System.out.println(name+" "+ Math.sqrt((x-x2)*(x-x2)+(y-y2)*(y-y2))+ " "+ a);
                try {
                    Bee.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    class Winnie extends Thread{
        private int x,y,w,h,size;

        private double r ;
        String name;
        private JPanel body = new JPanel();

        public Winnie(int x, int y, int size, String name,int w,int h){
            this.x = x;
            this.y = y;
            this.size = size;
            this.name = name;
            this.w = w;
            this.h = h;
            body.setBackground(new Color(60,8,8));
            body.setBounds(x,y,size,size);
            body.setLayout(null);
            body.setVisible(true);
            r= Math.sqrt(2)*size;
        }

        private static int getRandomNumberInRange(int min, int max) {

            if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
            }

            Random r = new Random();
            return r.nextInt((max - min) + 1) + min;
        }


        @Override
        public void run(){
            if(winnieDied==true){
                body.setBackground(Color.red);

            }
            while (winnieDied==false) {
                int changeH = Math.round(h/6);
                int changeW = Math.round(w/6);
                while (x+changeW>w || y>h+changeH){
                    changeH = Math.round(h/6);
                    changeW = Math.round(w/6);
                }
                body.setBounds(x + getRandomNumberInRange(-1*changeW, changeW), y + getRandomNumberInRange(-1*changeH, changeH), size, size);
                try {
                    Bee.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }


    }

}
