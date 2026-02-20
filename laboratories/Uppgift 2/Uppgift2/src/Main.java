public class Main {
    public static void main(String[] args) {

    SingleLinkedList<String> linkedList = new SingleLinkedList<>();
    linkedList.addFirst("A");
    linkedList.add(1,"B");
    linkedList.addLast("C");
        System.out.println(linkedList);
        System.out.println("Size of list is: " + linkedList.getSize());
        try {
            linkedList.remove(-1);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Error " + e.getMessage());
        }
        //rätt index
        linkedList.remove(1);
        System.out.println(linkedList);
        System.out.println("Get element: " + linkedList.get(0)); //om det rätt då A
        linkedList.set(1,"D"); //sätta nya element
        System.out.println(linkedList);

    }
}