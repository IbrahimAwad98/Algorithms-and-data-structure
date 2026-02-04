public class Test {

    public static int nrPaths(int m, int n){
        // Basfall: startpunkt
        if (m == 0 && n == 0){
            return 1;
        }

        // Börja från 0
        int steps = 0;

        if (m > 0){
            steps = nrPaths(m - 1, n);
        }

        if (n > 0){
            steps = steps + nrPaths(m, n - 1);
        }

        return steps;
    }

    public static void main(String[] args){
        System.out.println("Paths to (5,6): " + Test.nrPaths(5, 6));  // 462
    }
}