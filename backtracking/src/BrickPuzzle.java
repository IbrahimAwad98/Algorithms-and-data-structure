import java.util.*;
import java.util.LinkedList;

public class BrickPuzzle {

    private static final String START = "BBB_WWW";
    private static final String GOAL = "WWW_BBB";

    private static class State{
        String board;
        List<String> moves;

        public State(String board, List<String> moves){
            this.board = board;
            this.moves = moves;
        }
    }

    public static void solve(){
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new State(START, new ArrayList<>()));
        visited.add(START);

        while (!queue.isEmpty()){
            State current = queue.poll();
            //basefall 1: löst
            if (current.board.equals(GOAL)){
                System.out.println(String.join(", ", current.moves));
                continue; //vi fortsätter hitta fler därför
            }

            char[] board = current.board.toCharArray();

            for (int i = 0; i < board.length;i++){
                if (board[i] == 'B'){
                    move(queue,visited,current,board,i,i+1);
                    move(queue,visited,current,board,i,i+2);
                }
                if (board[i] == 'W'){
                    move(queue,visited,current,board,i,i-1);
                    move(queue,visited,current,board,i,i-2);
                }
            }
        }
    }
    private static void move(Queue<State> queue, Set<String> visited,
                             State current, char[] board, int from, int to){

        // basefall 2
        if (to < 0 ||to >= board.length){
            return;
        }
        // basefall 3
        if (board[to] != '_'){
            return;
        }

        char[] newBoard = board.clone();
        newBoard[to] = newBoard[from];
        newBoard[from] = '_';

        String newState = new String(newBoard);
        if (visited.contains(newState)){
            return;
        }
        visited.add(newState);

        List<String> newMoves = new ArrayList<>(current.moves);
        newMoves.add((from + 1) + "->" + (to + 1));
        queue.add(new State(newState, newMoves));
    }
}

