public class LinkedList<E> {
    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public void addLast(E item){
        Node<E> newNode = new Node<>(item, null);
        if (empty()){
            addFirst(item);
            return;
        }else {
            Node<E> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void addFirst(E item){
        head = new Node<>(item, head);
        size++;
    }

    public void add(int position, E item){
        if (position <0 || position > size){
            throw new IndexOutOfBoundsException("Wrong: " + position);
        }
        if (position == 0){
            addFirst(item);
            return;
        }
        Node<E> current = head;
        int index = 0;
        while (current != null && index < position - 1){
            current = current.next;
            index++;
        }
        Node<E> newNode = new Node<>(item,current.next);
        current.next = newNode;
        size++;
    }

    public void delete(E item){
        if (empty()){
            throw new IllegalStateException("List is empty");
        }
        if (head.data.equals(item)){
            head = head.next;
            size--;
            return;
        }
        Node<E> current = head;
        while (current.next != null){
            if (current.next.data.equals(item)){
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void merge(LinkedList<Integer> linkedList) {
        if (head == null) {
            head = (Node<E>) linkedList.head;
            return;
        }
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = (Node<E>) linkedList.head;
    }

    public String toString(){
        if (empty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null){
            sb.append(current.data);
            if (current.next != null){
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append(" -> null]");
        return sb.toString();
    }
}
