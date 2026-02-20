import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E>{

    private static class Node<E>{
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public SingleLinkedList(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void addFirst(E element){
        head = new Node<>(element, head);
        size++;
    }

    public void add(E elemnet){
        if (head == null){
            addFirst(elemnet);
        }else {
            Node<E> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new Node<>(elemnet,null);
            size++;
        }
    }

    public String toString(){
        if (head == null){
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
        sb.append("]");
        return sb.toString();
    }

    public Iterator<E> iterator(){
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<E> {
        private Node<E> current;
        private Node<E> previous; //den ska vi ta bort
        private Node<E> beforePrevious;
        private boolean canRemove;

        public LinkedIterator(){
            current = head;
            previous = null;
            beforePrevious = null;
            canRemove = false;
        }

        public boolean hasNext(){
            return current != null;
        }

        public E next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            beforePrevious = previous;
            previous = current;
            current = current.next;
            canRemove = true;
            return previous.data;
        }

        public void remove(){
            if (!canRemove){
                throw new IllegalStateException("remove() kan bara anropas en gång per next()"
                );
            }
            if (previous == head){
                head = head.next;
                previous = null;
            }else {
                beforePrevious.next = current;
                previous = beforePrevious;
            }
            canRemove = false;
            size--;
        }
    }
}
