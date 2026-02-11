public class DiviAndConq {
    public static int max(int[] array, int low, int high) {
        int m1, m2;
        //basefall: då första är max
        if (low == high) {
            return array[low];
        } else {
            m1 = max(array, low, (low + high) / 2);
            m2 = max(array, (low + high) / 2 + 1, high);
            if (m1 > m2) {
                return m1;
            } else {
                return m2;
            }
        }
    }


}


