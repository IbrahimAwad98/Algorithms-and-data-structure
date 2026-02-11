public class ShellSort {
    public static void shellSort(int[] array) {
        int n = array.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int index = gap; index < n; index++) {
                int data = array[index];
                int dataIndex = index;
                while (dataIndex > gap - 1 && data < array[dataIndex - gap]) {
                    array[dataIndex] = array[dataIndex - gap];
                    dataIndex -= gap;
                }
                array[dataIndex] = data;
            }
            if (gap == 2){
                gap = 1;
            }else {
                gap = (int)(gap/2.2);
            }
        }
    }
}
