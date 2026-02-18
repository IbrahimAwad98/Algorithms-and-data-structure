import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the gray box row (0-4): ");
        int greyRow = scanner.nextInt();
        System.out.println("Enter the gray box column (0-4): ");
        int greyColumn = scanner.nextInt();

        Puzzle puzzle = new Puzzle(greyRow, greyColumn);
        puzzle.solve();
        System.out.println("Total Number of solutions: " + puzzle.getNrOfSolutions());
    }
}
