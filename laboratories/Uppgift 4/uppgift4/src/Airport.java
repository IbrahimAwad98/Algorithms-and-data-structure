import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Airport {

    private Queue<Integer> landingQueue = new LinkedList<>();
    private Queue<Integer> takeoffQueue = new LinkedList<>();
    private int runwayBusy = 0;
    private int currentTime = 0;
    //alt: att man skippa arrayer (Dennis tips)
    private ArrayList<Integer> landingWaitTimes = new ArrayList<>();
    private ArrayList<Integer> takeoffWaitTimes = new ArrayList<>();
    private int maxLandingWait = 0;
    private int maxTakeoffWait = 0;
    private int totalTime = (10 * 365 * 24 * 60);
    private double intervalPercentage = 0.05;
    private int interval = 5;


    public void runSimulation(){
        while (currentTime < totalTime){

            // Nya plan dyker upp
            if (Math.random() < intervalPercentage){
                landingQueue.add(currentTime);
            }
            if (Math.random() < intervalPercentage){
                takeoffQueue.add(currentTime);
            }

            // om banan är upptagen
            if (runwayBusy > 0){
                runwayBusy -= interval;
            }

            // Om banan ledig
            if (runwayBusy == 0){
                if (!landingQueue.isEmpty()){

                    int arrivalTime = landingQueue.poll(); //FIFO
                    int waitTime = currentTime - arrivalTime;
                    landingWaitTimes.add(waitTime);

                    if (waitTime > maxLandingWait){
                        maxLandingWait = waitTime;
                    }
                    runwayBusy = 20;
                }
            }else if (!takeoffQueue.isEmpty()){
                int arrivalTime = takeoffQueue.poll();
                int waitTime = currentTime - arrivalTime;
                takeoffWaitTimes.add(waitTime);

                if (waitTime > maxLandingWait){
                    maxTakeoffWait = waitTime;
                }
                runwayBusy = 20;
            }
            // +5 min
            currentTime += interval;
        }
        printStatistics();
    }

    private void printStatistics(){
        double averageLanding = 0;
        double averageTakeoff = 0;

        if (!landingWaitTimes.isEmpty()){
            int sum = 0;
            for (int time: landingWaitTimes){
                sum += time;
            }
            averageLanding = (double) sum / landingWaitTimes.size();
        }
        if (!takeoffWaitTimes.isEmpty()){
            int sum = 0;
            for (int time: takeoffWaitTimes){
                sum += time;
            }
            averageTakeoff = (double) sum / takeoffWaitTimes.size();
        }
        System.out.println("Average for landing: " + String.format("%.2f", averageLanding) + " min");
        System.out.println("Average for takeoff: " + String.format("%.2f", averageTakeoff) + " min");
        System.out.println("Max wait time for landing: " + maxLandingWait + " min");
        System.out.println("Max wait time for start: " + maxTakeoffWait + " min");
        System.out.println("Total landing: " + landingWaitTimes.size());
        System.out.println("Total start: " + takeoffWaitTimes.size());
    }
}