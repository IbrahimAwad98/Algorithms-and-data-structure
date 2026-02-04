import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.addFirst("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println(linkedList);
        System.out.println("Size of list: " + linkedList.getSize());

        //vi testar iterator och remove metod via den
        Iterator<String> iterator = linkedList.iterator();
        iterator.next();
        iterator.remove(); //A
        System.out.println("After remove of first: " + linkedList);
        System.out.println("Size: " + linkedList.getSize());
        iterator.next();
        iterator.remove(); //B
        System.out.println("After remove of sceond: " + linkedList);
        System.out.println("Size: " + linkedList.getSize());
        //ta bort alla
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println("Last element: " + element);
            iterator.remove();
            System.out.println(linkedList);
        }
        System.out.println("Size: " + linkedList.getSize());

    }
}