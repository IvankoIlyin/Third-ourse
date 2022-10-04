public class forest {
    private int n,N;
    private pot pot;
    private winnnie winnnie;

    boolean isSleep;


    forest(int N, int n){
        this.N=N;
        this.n=n;
        pot = new pot(N);
        rebornBee(n);

    }


    private void rebornBee(int n){
        winnnie = new winnnie();
        isSleep=true;
        for(int i=0;i<n;i++){
            bee current = new bee();
            current.start();
        }

    }

    class pot {
        int N;
        int[] pot;
        boolean isEmpty,lock;
        pot(int N){
            this.N=N;
            pot = new int[N];
            for(int i=0;i<pot.length;i++){pot[i]=0;}
            isEmpty=true;
            lock=false;

        }

    }

    class bee extends Thread{


        @Override
        public void run(){
            while (true) {
                if (pot.isEmpty && !pot.lock) {
                    pot.lock = true;
                    for (int i = 0; i < pot.pot.length; i++) {
                        if (pot.pot[i] == 0) {
                            pot.pot[i] = 1;
                            System.out.println("Bee"+this.getName() +" cum in hole number "+ i );
                            break;
                        }
                        if (pot.pot[i] == 1 && i == pot.pot.length-1) {
                            winnnie.start();
                            pot.isEmpty = false;
                            isSleep = false;
                        }
                    }
                    try {
                        bee.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    pot.lock = false;

                }

            }
        }

    }

    class winnnie extends Thread{


        @Override
        public void run(){
            while (true){
                if(!isSleep && !pot.lock) {
                    for (int i = 0; i < pot.pot.length; i++) {
                        pot.pot[i] = 0;
                    }
                    System.out.println("Hole is empty");
                    isSleep = true;
                    try {
                        winnnie.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    pot.isEmpty = true;

                }

            }
        }

    }

}
