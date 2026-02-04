public class NB11 {
    public static int maxValue(int[] array, int index){
        if (index == array.length - 1){ //basefall
            return array[index];
        }
        int maxOfRest = maxValue(array, index + 1); //börja gå till base
       return Math.max(array[index],maxOfRest);
    }
}
