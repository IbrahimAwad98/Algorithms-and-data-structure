public class RobotPackage {
    private static final int maxDepth = 15;

    private String change(String string){
        char first = string.charAt(0);
        char second = string.charAt(1);
        String rest = string.substring(2);
        return second + "" + first + rest;
    }

    private String swap(String string){
        char last = string.charAt(4);
        String rest = string.substring(0,4);
        return last + rest;
    }

    private String solve(String current, String moves, int depth){
        // basefall 1: hittat lösning
        if (current.equals("ABCDE")){
            return moves;
        }
        // basefall 2: utanför djupet
        if (depth >= maxDepth){
            return null;
        }

        // operation b (change)
        String next = change(current);
        String result = solve(next, moves + "b" , depth + 1);
        if (result != null){
            return result;
        }

        //operation s (swap)
        next = swap(current);
        result = solve(next, moves + "s", depth +1);
        if (result != null){
            return result;
        }

        return null;
    }

    public String solution(String start){
        return solve(start, "", 0);
    }
}