public class snatch {
    stuff sklad[];
    stuff stuffBuffer[];
    int done;
    double totalPrice;
    ivanov ivanov;
    petrov petrov;
    nechiporuk nechiporuk;
    int countSklad,countBuffer;
    snatch(){

        sklad = new stuff[50];
        stuffBuffer = new stuff[5];
        for(int i=0;i<sklad.length;i++){
            sklad[i]=new stuff("Tovar"+String.valueOf(i+1), Math.random()*100,i+1);
        }
       GoSnatch();


    }

    public void GoSnatch(){
        done=1;
        ivanov = new ivanov();
        petrov = new petrov();
        nechiporuk = new nechiporuk();
        countSklad=0;
        countBuffer=0;
        ivanov.start();

    }


    class ivanov extends Thread{

        ivanov(){

        }

        @Override
        public void run(){
                while (true) {
                    if (done == 1) {
                        synchronized (stuffBuffer) {
                            if (sklad[countSklad].name != "0" && sklad[countSklad].id % 5 != 0) {
                                stuffBuffer[countBuffer] = new stuff(sklad[countSklad].name, sklad[countSklad].price, sklad[countSklad].id);
                                System.out.println("Ivanov snatch from sklad " + stuffBuffer[countBuffer].name);
                                sklad[countSklad].name = "0";
                                countBuffer++;
                                countSklad++;

                            }
                            if (sklad[countSklad].name != "0" && sklad[countSklad].id % 5 == 0) {
                                stuffBuffer[countBuffer] = new stuff(sklad[countSklad].name, sklad[countSklad].price, sklad[countSklad].id);
                                System.out.println("Ivanov snatch from sklad " + stuffBuffer[countBuffer].name);
                                sklad[countSklad].name = "0";
                                countSklad++;
                                done = 2;
                                petrov.start();
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



    }

    class petrov extends Thread{


        petrov(){
        }

        @Override
        public void run() {
            int i = 0;
            while (done == 2) {
                synchronized (stuffBuffer) {
                    System.out.println("Petrov loaded stuff into the carr " + stuffBuffer[i].name);
                    if (i == 4) {
                        done = 3;
                        countBuffer = 0;
                        nechiporuk.start();
                    }
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
            while (done == 3) {
                synchronized (stuffBuffer) {
                    int price = 0;
                    for (int i = 0; i < stuffBuffer.length; i++) {
                        price += stuffBuffer[i].price;
                    }
                    System.out.println("Nechiporuk calculated the price of stuff = " + price);
                    done = 1;


                }
            }

        }

    }



}
