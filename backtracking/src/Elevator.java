public class Elevator {
    public static int nrOfTrips(int levels, int up, int down, int destination){
        return nrOfTrips(levels,up,down,destination,1, 0);
    }

    private static int nrOfTrips(int levels, int up, int down, int destination, int position, int trips){
        if (position == destination){
            return trips;
        }
        if (position < 1 || position > levels){
            return -1;
        }
        if (trips >= 30){
            return Integer.MAX_VALUE;
        }
        int nrOfUp = Integer.MAX_VALUE;
        int nrOfDown = Integer.MAX_VALUE;
        if (position + up <= levels){
            nrOfUp = 1 + nrOfTrips(levels,up,down,destination,position + up, trips +1 );
        }
        if (position - down >= 1){
            nrOfDown =1 + nrOfTrips(levels,up,down,destination,position-down, trips +1);
        }
        return Math.min(nrOfUp,nrOfDown);
    }


}

