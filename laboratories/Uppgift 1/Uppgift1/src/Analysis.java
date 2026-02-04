public class Analysis {

    public static long count(int n){
        long r = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++)
                for (int k = j; k <= i + j; k++)
                    for (int m = 1; m <= i + j - k; m++)
                        r++;
        return r;
    }
}
