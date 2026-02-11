public class Car implements Comparable<Car>{
    private String model;
    private int year;
    private double milage;

    public Car(String model, int year, double milage){
        this.model = model;
        this.year = year;
        this.milage = milage;
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public double getMilage(){
        return milage;
    }

    public int compareTo(Car other){
        return this.model.compareTo(other.model);
    }

    public String toString(){
        return "Model [ " + model + "], EST: " + year + ", Milage= " + milage;
     }
}
