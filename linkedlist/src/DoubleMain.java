import java.util.Iterator;
public class DoubleMain {
    public static void main(String[] args){

        DbLinkedList<String> dbLinkedList = new DbLinkedList<>();
        System.out.println("List: ");
        System.out.println("Empty? " + dbLinkedList.empty());
        dbLinkedList.addFirst("A");
        dbLinkedList.add(1,"B");
        dbLinkedList.addLast("C");
        System.out.println(dbLinkedList);
        System.out.println("Size= " + dbLinkedList.size());
        dbLinkedList.removeLast();
        System.out.println(dbLinkedList);
        System.out.println("Size= " + dbLinkedList.size());
        dbLinkedList.removeFirst();
        System.out.println(dbLinkedList);
        System.out.println("Size= " + dbLinkedList.size());
        try {
            dbLinkedList.remove(1);
        }catch (IllegalArgumentException e ){
            System.out.println("Error: " + e.getMessage());
        }
        dbLinkedList.remove(0);
        System.out.println(dbLinkedList);
        System.out.println("Size= " + dbLinkedList.size());

        DbLinkedList<Integer> dbLinkedList1 = new DbLinkedList<>();
        dbLinkedList1.add(0,1);
        dbLinkedList1.add(1,2);
        dbLinkedList1.add(2,3);
        System.out.println(dbLinkedList1);

        Iterator<Integer> iter = dbLinkedList1.iterator();
        iter.next();
        try {
            iter.remove();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println(dbLinkedList1);
    }
}
