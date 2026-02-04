public class LinkedListMain {

    private static class Node{
        private String data;
        private Node next;
    }

    public static void main(String[] args) {

        Node node1 = new Node();
        node1.data = "Gilgamesh";

        Node node2 = new Node();
        node2.data = "löper";

        Node node3 = new Node();
        node3.data = "på";

        Node node4 = new Node();
        node4.data = "stäppen";
        node4.next = null; //eftersom den är sista noden

        //vi måste länka dem
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node head = node1; //head som pekar på första element
        System.out.print("[");
        Node current = head;
        while (current!= null){
            System.out.print(current.data);
            if(current.next != null){
                System.out.print(" ==> ");
            }
            current = current.next;
        }
        System.out.println("]");


        // testa att ta bort

        node2.next = node4; //att då det bli null och hoppa över node3
        System.out.println("Lista (utan på): ");
        System.out.print("[");
        current = head;
        while (current!= null){
            System.out.print(current.data);
            if(current.next != null){
                System.out.print(" ==> ");
            }
            current = current.next;
        }
        System.out.println("]");

        //vi testar två listor

        //lista 1
        Node x = new Node();
        x.data = "x";
        Node y = new Node();
        y.data = "y";
        Node z = new Node();
        z.data = "z";
        z.next = null;
        x.next = y;
        y.next = z;

        //lista 2
        Node a = new Node();
        a.data = "A";
        Node b = new Node();
        b.data = "B";
        Node c = new Node();
        c.data = "C";
        c.next = null;
        a.next = b;
        b.next = c;

        //sätta ihop dem
        z.next = a;

        System.out.println("Sammasätta listor: ");
        System.out.print("[");
        Node currentNode = x;
        while (currentNode != null){
            System.out.print(currentNode.data);
            if(currentNode.next != null){
                System.out.print(" ==> ");
            }
            currentNode = currentNode.next;
        }
        System.out.println("]");

        //klippa av listan halvvägs (dvs vid z)
        z.next = null;
        System.out.print("[");
        Node currentN = x;
        while (currentN != null){
            System.out.print(currentN.data);
            if(currentN.next != null){
                System.out.print(" ==> ");
            }
            currentN = currentN.next;
        }
        System.out.println("]");
        System.out.println("då andra lista är: ");
        System.out.print("[");
        Node curr = a;
        while (curr != null){
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" ==> ");
            }
            curr = curr.next;
        }
        System.out.println("]");
    }
}
