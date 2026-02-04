public class SearchMain {
    public static void main(String[] args) {

        //binär
        int[] array = {10,20,30,40,50,60,70,80,90,100,100};
        int target = 20;
        long startTime = System.nanoTime();
        int result = Serach.binarySearch(array,0,array.length-1,target);
        System.out.println("Söker efter " + target + ":at index " + result);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time: " + duration + "ns");


        //linär
        int[] array1 = {7, 2, 9, 1, 5, 3, 8, 4};
        int target1 = 1;
        int result1 = Serach.linarSearch(array1,0,target1);
        long startTime2 = System.nanoTime();
        System.out.println("Söker efter " + target1 + ":at index " + result1);
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        System.out.println("Time: " + duration2 + "ns");

        if (duration2 < duration){
            System.out.println("Binay is faster than linar");
        }else {
            System.out.println("Linar is faster than binary");
        }
    }
}