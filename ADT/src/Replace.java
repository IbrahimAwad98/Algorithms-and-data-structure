import java.util.ArrayList;

public class Replace {

    public static void replace(ArrayList<String> aList, String oldItem, String newItem){
        for(int i = 0; i <aList.size();i++){ //loopa hela lisa (linjär)
            String currentItem = aList.get(i); //hämta den som vill ersätta
            if(currentItem.equals(oldItem)){ //jämför (via equlas)
                aList.set(i,newItem); //ersätta med nya 0(1)
            }

        }
    }
}
