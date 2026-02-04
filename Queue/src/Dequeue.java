public class Dequeue<E> {

    private static class Node<E>{
        private E data;
        private Node<E> next;
        private Node<E> prev;

        private Node(E data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Dequeue(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public void offerFirst(E element){
        Node<E> newNode = new Node<>(element);
        if (empty()){
            tail = head = newNode;
        }else {
            //jobba med head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void offerLast(E element){
        Node<E> newNode = new Node<>(element);
        if (empty()){
            head = newNode;
            tail = newNode;
        }else {
            //jobba med tail
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public E pollFirst(){
        if (empty()){
            return null;
        }
        E data = head.data;
        if (size == 1){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public E pollLast(){
        if (empty()){
            return null;
        }
        E data = tail.data;

        if (size == 1){
            head = null;
            tail = null;
        }else {
            tail = tail.next;
            tail.prev = null;
        }
        size--;
        return data;
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
                sb.append(" <-> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
