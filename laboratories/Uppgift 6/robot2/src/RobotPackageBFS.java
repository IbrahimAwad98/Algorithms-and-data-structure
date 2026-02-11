import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RobotPackageBFS {

    private static class State{
        String current, moves;

        public State(String current, String moves){
            this.current = current;
            this.moves = moves;
        }
    }

    // b-operation
    private String applyB(String s) {
        char first = s.charAt(0);
        char second = s.charAt(1);
        String rest = s.substring(2);
        return second + "" + first + rest;
    }

    // s-operation
    private String applyS(String s) {
        char last = s.charAt(4);
        String rest = s.substring(0, 4);
        return last + rest;
    }


    public String solution(String start){
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(start, ""));

        Set<String> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()){

            State state = queue.remove();

            // basefall 1: lösning hittad
            if (state.current.equals("ABCDE")){
                return state.moves;
            }

            String next = applyB(state.current);
            if (!visited.contains(next)){
                visited.add(next);
                queue.add(new State(next,state.moves + "b"));
            }

            next = applyS(state.current);
            if (!visited.contains(next)) {
                visited.add(next);
                queue.add(new State(next, state.moves + "s"));
            }
        }
        return null;
    }
}
