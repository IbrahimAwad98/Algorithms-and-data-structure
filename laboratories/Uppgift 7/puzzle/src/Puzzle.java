public class Puzzle {
    private static final int[][][] ROTATIONS = {
            {{0, 0}, {1, 0}, {0, 1}}, // R0
            {{0, 0}, {1, 0}, {0, -1}}, // R1
            {{0, 0}, {-1, 0}, {0, 1}}, // R2
            {{0, 0}, {-1, 0}, {0, -1}}  // R3
    };
    private static final int SIZE = 5;
    private int[][] board;
    private int grayRow;
    private int grayCol;
    private int nrOfSolutions;

    public Puzzle(int grayRow, int grayCol) {
        this.board = new int[SIZE][SIZE];
        this.grayRow = grayRow;
        this.grayCol = grayCol;
        this.nrOfSolutions = 0;
    }

    //hitta först tömma rutan (ej grå)
    private int[] findFirstEmpty() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (r == grayRow && c == grayCol) {
                    continue; //grå rutan som inte täckas
                }
                if (board[r][c] == 0) {
                    return new int[]{r, c}; //
                }
            }
        }
        return null; //alla rutor fyllda
    }

    public void solve() {
        int[] position = findFirstEmpty();

        //basefall 1: lösning hittades!
        if (position == null) {
            nrOfSolutions++;
            printBorad();
            return;
        }

        int row = position[0];
        int col = position[1];

        for (int rot = 0; rot < 4; rot++) {
            for (int[] offset : ROTATIONS[rot]) {
                // Flytta ankaret så att detta offset täcker (row,col)
                int anchorRow = row - offset[0];
                int anchorCol = col - offset[1];

                if (fits(rot, anchorRow, anchorCol)) {
                    place(rot, anchorRow, anchorCol);
                    solve();
                    remove(rot, anchorRow, anchorCol);
                }
            }
        }
    }

    private boolean fits(int rotation, int row, int col) {
        for (int[] offset : ROTATIONS[rotation]) {
            int r = row + offset[0];
            int c = col + offset[1];
            // checka först om den går utanför brädet
            if (r < 0 || r >= SIZE || c < 0 || c >= SIZE) {
                return false;
            }
            // om den är den grå
            if (r == grayRow && c == grayCol) {
                return false;
            }
            // om cellen redan tagen
            if (board[r][c] != 0) {
                return false;
            }
        }
        return true;
    }

    private void place(int rotation, int row, int col) {
        for (int[] offset : ROTATIONS[rotation]) {
            board[row + offset[0]][col + offset[1]] = 1;
        }
    }

    private void remove(int rotation, int row, int col) {
        for (int[] offset : ROTATIONS[rotation]) {
            board[row + offset[0]][col + offset[1]] = 0;
        }
    }

    private void printBorad() {
        System.out.println("*** Solutions " + nrOfSolutions + " ***");
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (r == grayRow && c == grayCol) {
                    System.out.print("G ");
                } else if (board[r][c] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public int getNrOfSolutions() {
        return nrOfSolutions;
    }
}
