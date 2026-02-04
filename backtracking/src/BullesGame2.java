import java.util.*;

public class BullesGame2 {
    private static class State {
        int blue, white, red, steps;

        State(int blue, int white, int red, int steps) {
            this.blue = blue;
            this.white = white;
            this.red = red;
            this.steps = steps;
        }
    }

    public static int solve(int blue, int white, int red) {

        Queue<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(new State(blue, white, red, 0));
        visited.add(key(blue, white, red));

        while (!queue.isEmpty()) {
            State s = queue.poll();

            if (s.blue == s.white && s.white == s.red) {
                return s.steps;
            }

            if (s.steps >= 15) {
                continue;
            }

            if (s.blue >= 1) {
                addState(queue, visited, s.blue - 1, s.white + 1, s.red + 3, s.steps + 1);
            }

            if (s.white >= 1) {
                addState(queue, visited, s.blue + 2, s.white - 1, s.red + 4, s.steps + 1);
            }

            if (s.red >= 1) {
                addState(queue, visited, s.blue + 1, s.white + 5, s.red - 1, s.steps + 1);
            }
        }

        return -1; // omöjligt
    }


    private static void addState(Queue<State> q, Set<String> visited,
                                 int blue, int white, int red, int steps) {
        String k = key(blue, white, red);
        if (!visited.contains(k)) {
            visited.add(k);
            q.add(new State(blue, white, red, steps));
        }
    }

    private static String key(int blue, int white, int red) {
        return blue + "," + white + "," + red;
    }

    /*
       public static void main(String[] args) {
        test(2, 5, 0);
        test(1, 0, 1);
        test(2, 1, 0);
        test(3, 2, 1);
        test(5, 2, 1);
        test(5, 1, 3);
    }
     */

    private static void test(int blue, int white, int red) {
        int result = solve(blue, white, red);
        System.out.println("Start (" + blue + ", " + white + ", " + red + ")");
        if (result == - 1){
            System.out.println("Not possible");
        }else {
            System.out.println("Mini swaps: " + result);
        }
    }
}
