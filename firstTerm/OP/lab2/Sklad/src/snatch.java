public class snatch {
    stuff sklad[];
    stuff stuffBuffer[];
    int done;
    double totalPrice;
    ivanov ivanov;
    petrov petrov;
    nechiporuk nechiporuk;
    goSnatch goSnatch;

    snatch(){

        sklad = new stuff[50];
        stuffBuffer = new stuff[5];
        for(int i=0;i<sklad.length;i++){
            sklad[i]=new stuff("Tovar"+String.valueOf(i+1), Math.random()*100,i+1);
        }
        goSnatch=new goSnatch();
        goSnatch.start();


    }


    class ivanov extends Thread{

        ivanov(){

        }

        @Override
        public void run(){
            int i= 0;
            synchronized (stuffBuffer) {
                while (done == 1) {
                    if (sklad[i].id % 5 == 0) {
                        done = 2;
                        petrov = new petrov();
                        petrov.start();
                    }
                    if (sklad[i].name != "0") {
                        stuffBuffer[i] = new stuff(sklad[i].name, sklad[i].price, sklad[i].id);
                        System.out.println("Ivanov snatch from sklad " + stuffBuffer[i].name);
                        sklad[i].name = "0";
                        i++;
                    }

                    try {
                        ivanov.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        }



    }

    class petrov extends Thread{


        petrov(){
        }

        @Override
        public void run() {
            int i = 0;
            while (done==2) {
                synchronized (stuffBuffer) {
                    System.out.println(done);
                    if (i == 4) {
                        done = 3;
                        nechiporuk=new nechiporuk();
                        nechiporuk.start();
                    }
                    System.out.println("Petrov loaded stuff into the carr " + stuffBuffer[i].name);
                    i++;

                    try {
                        petrov.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }


        }
    }

    class nechiporuk extends Thread{

        @Override
        public void run() {
            if (done==3) {
                synchronized (stuffBuffer) {
                    int price=0;
                    for(int i =0;i<stuffBuffer.length;i++){
                        price+=stuffBuffer[i].price;
                    }
                    System.out.println("Nechiporuk calculated the price of stuff = " + price);
                    done = 1;
                    ivanov = new ivanov();
                    ivanov.start();

                    try {
                        petrov.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }


        }

    }

    class goSnatch extends Thread{

        @Override
        public void run(){
            done = 1;

            while (true) {
                ivanov = new ivanov();
                petrov = new petrov();
                nechiporuk = new nechiporuk();
                ivanov.start();
                petrov.start();
                nechiporuk.start();
            }
        }

    }


}
