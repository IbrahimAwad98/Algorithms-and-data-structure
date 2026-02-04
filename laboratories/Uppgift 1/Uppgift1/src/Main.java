public class Main {
    public static void main(String[] args) {

        //vi räknar försök 1
        System.out.println("T(n)");
        for(int n = 1; n <= 40;n++){
            System.out.println(n + "=\t" + Analysis.count(n) + " gånger");
        }
        //förök 3 då T(1000)
        int n = 1000;
        long result = Analysis.count(n);
        System.out.println("\nT(" + n + ") = " + result);

    }
}