public class Factorial {
    public static int factorial(int n){
        if (n == 0){
            return 1;
        }else {
            return n * factorial(n - 1);
        }
    }

    public static int highest(int a, int b, int c){
        int x = a;
        if (b > x){
            x = b;
        }
        if (c > x)
        {
            x = c;
        }
        return x;
    }

    public static int gcd(int a, int b){
        if (b == 0){ //basefall
            return a;
        }else {
            return gcd(b,a%b);
        }
    }
}
