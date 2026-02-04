import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write in expression (q to quit): ");
        while (true){
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("q")){
                break;
            }
            try {
                double result = Calculator.evaluate(input);
                System.out.println("= " + result + "\n");
            }catch (Exception e){
                System.out.println("Wrong: "+ e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Bye bye!");
    }
}