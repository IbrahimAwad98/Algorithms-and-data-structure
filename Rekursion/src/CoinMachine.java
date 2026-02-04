public class CoinMachine {
    public static int cost(int points, int goal){
       //basefall1:  om vi når målet
        if (points == goal){
            return 0;
        }
        //basefall2: om vi passerar målet
        if (points > goal){
            return -1;
        }

        int choose1 = cost(points * 3, goal);
        int choose2 = cost(points + 4,goal);

        //om båda val inte leder till något
        if (choose1 == -1 && choose2 == -1){
            return -1;
        }
        //om val 1 inte funkar
        if (choose1 ==-1){
            return 5 + choose2;
        }
        //om val 2 inte funkar
        if (choose2 == -1){
            return 10 + choose1;
        }

        //om båda kan användas
        int cost1 = 10 + choose1;
        int cost2 = 5 + choose2;

        if (cost1 < cost2){
            return cost1;
        }else {
            return cost2;
        }
    }

    public static int cost(int points, int goal, int totalValue){
        //basefall1:  om vi når målet
        if (points == goal){
            return totalValue;
        }
        //basefall2: om vi passerar målet
        if (points > goal){
            return -1;
        }

        //här den samlar kostnad medans metod 1 retunera det direkt.
        int cost1 = cost(points * 3, goal, totalValue + 10);
        int cost2 = cost(points + 4,goal, totalValue + 5);

        //om båda val inte leder till något
        if (cost1 == -1 && cost2 == -1){
            return -1;
        }
        if (cost1 == -1){
            return cost2;
        }
        if (cost2 == -1){
            return cost1;
        }

        if (cost1 < cost2){
            return cost1;
        }else {
            return cost2;
        }
    }
}
