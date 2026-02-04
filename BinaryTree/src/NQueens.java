public class NQueens {
    private int n;
    private int[] queens;
    private int solutionCount;

    private NQueens(int n){
        this.n = n;
        this.queens = new int[n];
        this.solutionCount = 0;
    }

    public void solve(){
        System.out.println("Löser " + n + "-damer problemet...\n");
        placeQueen(0);  // Börja med rad 0
        System.out.println("\nTotalt antal lösningar: " + solutionCount);
    }

    private void placeQueen(int row){

        if (row == n){
            solutionCount++;
            printSolution();
            return;
        }
        for (int col = 0; col < n; col++){
            if (isSafe(row,col)){
                queens[row] = col;
                placeQueen(row +1);
            }
        }
    }

    private boolean isSafe(int row, int col){
        for (int prevsRow = 0; prevsRow < row;prevsRow++){
            int prevCol = queens[prevsRow];
            if (prevCol == col){
                return false;
            }
            if (Math.abs(prevsRow - row) == Math.abs(prevCol - col)){
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        System.out.println("Lösning " + solutionCount + ":");
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (queens[row] == col) {
                    System.out.print("Q ");  // Dam här
                } else {
                    System.out.print(". ");  // Tom ruta
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ange antal damer (n): ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("n måste vara minst 1!");
            return;
        }

        NQueens nQueens = new NQueens(n);
        long startTime = System.currentTimeMillis();

        nQueens.solve();

        long endTime = System.currentTimeMillis();
        System.out.println("Tid: " + (endTime - startTime) + " ms");

        scanner.close();
    }

}
