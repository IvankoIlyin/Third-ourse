import java.util.concurrent.ThreadLocalRandom;
public class sProcess {
  public int cputime;
  public int ioblocking;
  public int cpudone;
  public int ionext;
  public int numblocked;
  public int quantum;
  public int id;

  public sProcess (int cputime, int ioblocking, int cpudone, int ionext, int numblocked) {
    this.cputime = cputime;
    this.ioblocking = ioblocking;
    this.cpudone = cpudone;
    this.ionext = ionext;
    this.numblocked = numblocked;
    this.quantum=ThreadLocalRandom.current().nextInt(1,10);
    this.id=0;
  }

}
