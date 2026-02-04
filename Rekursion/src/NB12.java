public class NB12 {
    public static int power(int x, int n){
        if (n == 0){ //basefall
            return 1;
        }
        return x * power(x,n-1);
    }

    public static int powerIterativ(int x, int n){
        if (n == 0){ // basefall
            return 1;
        }
        //x^n = x * x * x...(n gånger)
        int result = 1; // börja med 1
        for (int i = 1;i <= n;i++){ // loopar n gånger
            result *= x; // Multiplicera med x varje gång
        }
       return result;
    }
}