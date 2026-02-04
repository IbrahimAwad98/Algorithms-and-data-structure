public class Serach {
    public static int binarySearch(int[] array, int low, int high,int target){
        //basefall 1: vi hittar inte målet (ej sorrterad array)
        if (low > high){
            return -1;
        }
        int mid = low +(high - low)/2;
        //basefall 2: vi jämför med mid
        if (array[mid] == target){
            return mid;
        }
        //vi söker på vänstra sidan
        if (target < array[mid]){
            return binarySearch(array,low,mid-1,target);
        }
        return binarySearch(array,mid+1,high,target);
    }

    public static int linarSearch(int[]array, int position, int target){
       if (position==array.length){
           return -1;
       }
       if (array[position] == target){
           return position;
       }
       return linarSearch(array,position+1,target);
    }
}
