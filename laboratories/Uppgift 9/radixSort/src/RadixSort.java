public class RadixSort {
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        //räkna antal förekomster
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10; //ex 2/1 % 10 = 2
            count[digit]++; // då 2++ = 3 så [0,0,1,...]
        }

        //räkna Kumulativa positioner
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        //bygga output-array
        for (int i = n - 1; i >= 0; i--) { //bakifrån för stabiltet
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        //Kopiera tillbaka
        System.arraycopy(output, 0, arr, 0, n);
    }


    public static void radixSort(int[] arr) {
        int max = findMax(arr); //om vi har 802 då 3 siffror pass

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}
