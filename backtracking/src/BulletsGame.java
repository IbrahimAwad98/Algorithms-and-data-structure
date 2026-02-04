public class BulletsGame {
    public static int swap(int blue, int white, int red, int nrOfswaps){
        //basefall 1 vi är framme
        if (blue == white && white == red){
            return 0;
        }
        //basefall 2 mer än djupet
        if (nrOfswaps >= 15){
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int result;

        if (blue >= 1){
            result = swap(blue-1,white+1,red+3, nrOfswaps +1);
            if (result != -1){
                min = Math.min(min,1 + result);
            }
        }
        if (white >= 1){
            result = swap(blue +2,white-1,red+4, nrOfswaps+1);
            if (result != -1){
                min = Math.min(min,1+result);
            }
        }
        if (red >= 1){
            result = swap(blue +1,white+5,red-1, nrOfswaps+1);
            if (result != -1){
                min = Math.min(min,1+result);
            }
        }

        //om inget funkar
        if (min == Integer.MAX_VALUE){
            return -1;
        }

        return min;
    }

    private static void test(int blue, int white, int red){
        int result = BulletsGame.swap(blue,white,red,0);
        System.out.print("Start (" + blue + ", " + white + ", " + red + "): ");
        if (result == -1){
            System.out.println("Not possible");
        }else {
            System.out.println("Mini swaps: " + result);
        }
    }
/*
   public static void main(String[] args){
        test(2, 5, 0);
        test(1, 0, 1);
        test(2, 1, 0);
        test(3, 2, 1);
        test(5, 2, 1);
        test(5, 1, 3);
    }
 */

}
