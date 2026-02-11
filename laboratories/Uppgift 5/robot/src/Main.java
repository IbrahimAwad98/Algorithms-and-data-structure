import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        RobotPackage robotPackage = new RobotPackage();

        System.out.print("Enter package order (5 letters A-E): ");
        String input = scanner.nextLine().toUpperCase();

        if (input.length()!= 5){
            System.out.println("Wrong! it should be only 5");
            return;
        }

        String result = robotPackage.solution(input);

        if (result != null){
            System.out.println("Solution: " + result);
            System.out.println("Total steps: " + result.length());
        }else {
            System.out.println("Solution is missing");
        }

        scanner.close();
    }
}
