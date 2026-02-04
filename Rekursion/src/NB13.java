public class NB13 {
    public static double rot(int n, double a, double e){
        if (Math.abs(a * a - n) < e){ //basefall
            return a;
        }
        double fraction = (a * a + n ) / (2 * a);
        return rot(n,fraction,e);
    }
}
