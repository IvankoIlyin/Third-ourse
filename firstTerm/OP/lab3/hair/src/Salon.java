import java.util.LinkedList;
import java.util.Queue;

public class Salon {
        private Queue<Customer> queue = new LinkedList<>();
        private Barber barber;
        private Object controll;

        public void StartDay(int customersPerDay){
            controll = new Object();
            barber = new Barber();
            barber.start();
            for(int i = 0; i < 4; i++){
                Customer newCustomer = new Customer();
                newCustomer.start();
                queue.add(newCustomer);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Customer newCustomer = new Customer();
            newCustomer.start();
            queue.add(newCustomer);

        }

        class Customer extends Thread{
            public boolean isAsleep = true;

            @Override
            public void run() {
                while (!interrupted()){
                    synchronized (controll){
                        if(!barber.isAsleep){
                            try {
                                controll.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        else{
                            controll.notifyAll();
                        }
                    }
                }
            }
        }

        class Barber extends Thread{
            public boolean isAsleep = true;

            @Override
            public void run() {
                while (!interrupted()){
                    synchronized (controll){
                        if(queue.isEmpty()){
                            try {
                                isAsleep = true;
                                System.out.println("Barber asleep");
                                controll.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        else {
                            System.out.println("Barber awake");
                            isAsleep = false;
                            System.out.println(queue.size());
                            queue.remove();
                            System.out.println("Took new customer");
                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
}
