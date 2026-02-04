import java.util.ArrayList;

public class P2 {

    public static void delete(ArrayList<String> alist, String target){
       for(int i = alist.size() -1; i >= 0;i--){ //loopa bakåt för att flytta element åt vänster
           if(alist.get(i).equals(target)){ //jämför
               alist.remove(i);
           }
       }
    }
}
