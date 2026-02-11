import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // selection & insertion

        int[] array1, array2;
        System.out.println("Selection");
        array1 = new int[]{5, 2, 8, 1, 9, 3};
        System.out.println("Before");
        System.out.println(Arrays.toString(array1));
        SelectAndInsert.selectionSort(array1);
        System.out.println("After");
        System.out.println(Arrays.toString(array1));

        System.out.println("Insertion");
        array2 = new int[]{6, 3, 9, 5, 1, 2};
        System.out.println("Before");
        System.out.println(Arrays.toString(array2));
        SelectAndInsert.insertionSort(array2);
        System.out.println("After");
        System.out.println(Arrays.toString(array2));
        

        // divide & conquer
        /*
        int[] array = {7,6,12,3,9,5,10,1};
        int result = DiviAndConq.max(array,0,array.length -1);
        System.out.println("Max: " + result);
         */

        //quick sort
        /*
         int[] array = {10,7,8,9,1,5};
        int n = array.length;
        QuickSort.quickSort(array,0,n-1);
        for (int val: array){
            System.out.println(val + " ");
        }
         */

        //merge sort
        /*
        int[] arr;
        arr = new int[]{5, 2, 8, 1, 9, 3};
        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{5, 4, 3, 2, 1};
        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{3, 3, 1};
        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
         */

        //ShellSort
        /*
        int[] array = {5, 2, 8, 1, 9, 3};
        ShellSort.shellSort(array);
        System.out.println(Arrays.toString(array));
         */
    }
}