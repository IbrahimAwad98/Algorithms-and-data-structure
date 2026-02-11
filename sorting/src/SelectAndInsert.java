import java.util.Arrays;

public class SelectAndInsert {

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int index = 0; index <= n - 2; index++) {
            int minIndex = index;

            for (int i = index + 1; i <= n - 1; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }

            int temp = array[index];
            array[index] = array[minIndex];
            array[minIndex] = temp;

        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int index = 1; index <= n - 1; index++) {
            int data = array[index];
            int dataIndex = index;
            while (dataIndex > 0 && data < array[dataIndex - 1]) {
                array[dataIndex] = array[dataIndex - 1];
                dataIndex--;
            }
            array[dataIndex] = data;
        }
    }

}
