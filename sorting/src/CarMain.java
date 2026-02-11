
import java.util.Arrays;
import java.io.*;

public class CarMain {
    public static void main(String[] args) throws Exception{
        //läs filen
        int count = 0;
        BufferedReader counter = new BufferedReader(new FileReader("Cars.txt"));
        while (counter.readLine() != null){
            count++;
        }
        counter.close();

        //kopiera till array
        Car[] cars = new Car[count];
        BufferedReader reader = new BufferedReader(new FileReader("Cars.txt"));
        for (int i = 0; i <count;i++){
            String line = reader.readLine();
            String[] parts = line.split(",");
            String model = parts[0].trim();
            int year = Integer.parseInt(parts[1].trim());
            double milage = Double.parseDouble(parts[2].trim());
            cars[i] = new Car(model,year,milage);
        }
        reader.close();


        //sortera via java API
        Arrays.sort(cars);

        //kopiera till fil igen
        PrintWriter writer = new PrintWriter(new FileWriter("SortedCars.txt"));
        for (Car c: cars){
            writer.println(c);
        }
        writer.close();

        //CompareCar
        Arrays.sort(cars, new CompareCar());
        writer = new PrintWriter(new FileWriter("SortedComparator.txt"));
        for (Car c: cars){
            writer.println(c);
        }
        writer.close();

    }
}
