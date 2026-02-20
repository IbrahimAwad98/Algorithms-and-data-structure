import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        RobotPackageBFS robot = new RobotPackageBFS();

        System.out.print("Enter package order (5 letters A-E): ");
        String input = scanner.nextLine().toUpperCase();

        if (input.length() != 5) {
            System.out.println("Wrong! Must be 5 letters.");
            return;
        }

        String result = robot.solution(input);
        if (result != null) {
            System.out.println("SHORTEST solution found!");
            System.out.println("Drawing order: " + result);
            System.out.println("Total steps: " + result.length());
        } else {
            System.out.println("No solution exists.");
        }

        scanner.close();
    }
}
