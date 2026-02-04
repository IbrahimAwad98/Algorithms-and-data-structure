public class LinkedList<E>{
    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data){
            this.data = data;
            next = null;
        }
    }

    private Node<E> head;


    public LinkedList(){
        head = null;
    }

    public int size(){
        return sizeRecursive(head);
    }

    private int sizeRecursive(Node<E> current){
        if (current == null){
            return 0;
        }
        return 1 + sizeRecursive(current.next);
    }

   public void add(int position, E item){
        if (position < 0 || position > size()){
            throw new IllegalArgumentException("Wrong: " +position);
        }
        Node<E> newNode = new Node<>(item);
        if (position == 0){
            newNode.next = head;
            head = newNode;
        }else {
            Node<E> current = head;
            int index = 0;
            while (index < position- 1){
                current = current.next;
                index++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
   }

   public Node<E> getNode(int index){
        return getNodeRecursive(head,index);
   }

   private Node<E> getNodeRecursive(Node<E> current, int index){
        if (index == 0){
            return current;
        }
        return getNodeRecursive(current.next,index - 1);
   }

   public String toString(Node<E> newNode){
        if (newNode.next != null){
            return newNode.data.toString() + " -> " + toString(newNode.next);
        }
        return newNode.data.toString();
   }

   public String toString(){
        if (head!= null){
            return "[" + toString(head)+ "]";
        }
        return "[]";
   }
}
