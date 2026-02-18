import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array1 = {2, 1, 3, 3, 1, 0};
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(array1));
        System.out.println("After sorting");
        System.out.println(Arrays.toString(array1));

        int[] array2 = {170, 45, 75, 90, 2, 802, 24, 66};
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(array2));
        RadixSort.radixSort(array2);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(array2));


        // en miljon positiva heltal
        int n = 1_000_000;
        int[] array = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(Integer.MAX_VALUE); // alla möjliga värden
        }
        //System.out.println(Arrays.toString(array));

        //mäta tid med sortering
        long startTime = System.currentTimeMillis();
        RadixSort.radixSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + " ms");

        //verifiera
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                sorted = false;
                System.out.println("Wrong index: " + i);
                break;
            }
        }
        if (sorted) {
            System.out.println("Radix sorting is working!");
        }else {
            System.out.println("Radix sorting is not working!");
        }
    }
}
