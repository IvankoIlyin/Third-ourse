import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Vector;
import java.io.*;

public class RoundRobin {


    public static Results Run(int runtime, Vector<sProcess> processVector, Results result) {
        int currentProcess = 0;
        int timeSlice = 2;
        int comptime = 0;
        int completed = 0;
        int size = processVector.size();
        String resultsFile = "Summary-Processes";
        result.schedulingType="Preemptive Scheduling";
        result.schedulingName="Round Robin";
        for(int i=0;i<size;i++){
            processVector.get(i).id=i+1;
        }
        Deque<sProcess> processes = new ArrayDeque<>(processVector);
        try{
            PrintStream out = new PrintStream(new FileOutputStream(resultsFile));
            sProcess process = (sProcess) processVector.elementAt(currentProcess);
            out.println("Process: " + process.id + " registered... (" + process.cputime + " " + process.ioblocking + " " + process.cpudone + " " + process.cpudone + ")");
            while(comptime<=runtime){
                if(process.cpudone == process.cputime){
                    completed+=1;
                    out.println("Process: " + process.id + " completed... (" + process.cputime + " " + process.ioblocking + " " + process.cpudone + " " + process.cpudone + ")");
                    if(completed==size){
                        result.compuTime=comptime;
                        out.close();
                        return  result;
                    }
                    process = processes.removeFirst();
                    currentProcess+=1;
                    out.println("Process: " + process.id + " registered... (" + process.cputime + " " + process.ioblocking + " " + process.cpudone + " " + process.cpudone + ")");
                }
                if(process.quantum>timeSlice){
                    out.println("Process: " + process.id + " spent it`s quantum... (" + process.cputime + " " + process.ioblocking + " " + process.cpudone + " " + process.cpudone + ")");
                    process.numblocked+=1;
                    process.quantum=process.quantum-timeSlice;
                    processes.addLast(process);
                    process = processes.removeFirst();
                    currentProcess+=1;
                    out.println("Process: " + process.id + " registered... (" + process.cputime + " " + process.ioblocking + " " + process.cpudone + " " + process.cpudone + ")");
                }
                if(process.ioblocking == process.ionext){
                    out.println("Process: " + process.id + " I/O blocked... (" + process.cputime + " " + process.ioblocking + " " + process.cpudone + " " + process.cpudone + ")");
                    process.numblocked+=1;
                    process.ionext=0;
                    processes.addLast(process);
                    process=processes.removeFirst();
                    currentProcess+=1;
                    out.println("Process: " + process.id + " registered... (" + process.cputime + " " + process.ioblocking + " " + process.cpudone + " " + process.cpudone + ")");

                }
                process.cpudone+=1;
                process.ionext+=1;
                comptime+=1;
            }
            out.close();
        }catch (IOException e){}
        result.compuTime=comptime;
        return result;
    }


}
