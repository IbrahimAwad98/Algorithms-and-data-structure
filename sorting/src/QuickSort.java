public class QuickSort {
    public static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    //rekusion
    static void quickSort(int[] array, int left, int right) {
        //basefall: 0 eller 1 element
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array,left,right);
        // Sortera vänster del
        quickSort(array,left,pivotIndex-1);
        // Sortera höger del
        quickSort(array,pivotIndex+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array,j,i);
            }
        }
        swap(array,i+1,right);
        return i +1;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
