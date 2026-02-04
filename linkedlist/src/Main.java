import java.util.Iterator;
public class Main {
    public static void main(String[] args) {

        //single LinkedList
        /*
         LinkedList<String> stringLinkedList = new LinkedList<>();
        System.out.println("Empty? " + stringLinkedList.empty());
        stringLinkedList.addFirst("A");
        stringLinkedList.add(1,"B");
        stringLinkedList.addLast("C");
        System.out.println(stringLinkedList);
        System.out.println("Size= " + stringLinkedList.size());
        //testa delete
        stringLinkedList.delete("C");
        System.out.println(stringLinkedList);
        System.out.println("Size= " + stringLinkedList.size());

        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.addFirst(1);
        integerLinkedList.add(1,2);
        integerLinkedList.addLast(3);
        System.out.println(integerLinkedList);
        System.out.println("Size= " + integerLinkedList.size());

        //testa merge
        stringLinkedList.merge(integerLinkedList);
        System.out.println(stringLinkedList);
         */
        //iterator
        /*
        SingleLinkedList<String> linkedList = new SingleLinkedList<>();
        linkedList.addFirst("A");
        linkedList.add(1,"B");
        linkedList.add(2,"C");
        System.out.println(linkedList);
        linkedList.set(1,"X");
        System.out.println(linkedList);
        System.out.println("Value of index '2' is: " + linkedList.get(2));
        linkedList.remove(1);
        System.out.println(linkedList);

        Iterator<String> iter = linkedList.iterator();
        while (iter.hasNext()){
            String elements = iter.next();
            System.out.println(elements);
        }
         */

    }
}