public class MergeSort {
    public static void mergeSort(int[] array) {
        int n = array.length;

        //basefall 1
        if (n == 1) {
            return;
        }

        int[] b = new int[n / 2];
        int[] c = new int[n - n / 2];


        for (int i = 0; i < b.length; i++) {
            b[i] = array[i];
        }


        for (int i = 0; i < c.length; i++) {
            c[i] = array[n / 2 + i];
        }

        // Sortera vänster halva rekursivt
        mergeSort(b);

        // Sortera höger halva rekursivt
        mergeSort(c);

        // Sammanfoga de två sorterade halvorna tillbaka in i a
        merge(b, c, array);
    }

    private static void merge(int[] a, int[] b, int[] c) {
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        // Jämför "framsidan" av varje halva, ta det minsta elementet
        while (indexA < a.length && indexB < b.length) {
            if (a[indexA] <= b[indexB]) {
                c[indexC++] = a[indexA++];  // ta från vänster, flytta båda pekar
            } else {
                c[indexC++] = b[indexB++];  // ta från höger
            }
        }

        while (indexA < a.length) {
            c[indexC++] = a[indexA++];
        }

        while (indexB < b.length) {
            c[indexC++] = b[indexB++];
        }
    }
}
