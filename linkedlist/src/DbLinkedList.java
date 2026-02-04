import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DbLinkedList<E> {
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

    public DbLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public void addFirst(E item){
        Node<E> newNode = new Node<>(item);
        if (head == null){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head=newNode;
        }
        size++;
    }

    public void addLast(E item){
        Node<E> newNode = new Node<>(item);
        if (tail == null){
            tail = newNode;
            head = newNode;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int position, E item){
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        }

        if (position == 0){
           addFirst(item);
           return;
        }

        if (position == size){
            addLast(item);
            return;
        }
        Node<E> current = head;
        int index = 0;
        while (current != null && index < position -1){
                current = current.next;
                index++;
        }

        Node<E> newNode = new Node<>(item);
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null){
                current.next.prev = newNode;
        }
        current.next = newNode;
        size++;
    }

    public E removeFirst(){
        if (empty()){
            throw new IllegalStateException("List is empty");
        }
        E data = head.data;
        if (head == tail){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public E removeLast(){
        if (empty()){
            throw new IllegalStateException("List is empty");
        }
        E data = tail.data;
        if (head == tail){
            tail = null;
            head = null;
        }else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    public E remove(int position){
        if (position < 0 || position >= size){
            throw new IllegalArgumentException("Wrong position: " + position);
        }
        if (position == 0){
           return removeFirst();
        }
        if (position == size -1){
           return removeLast();
        }
        Node<E> current = head;
        int index = 0;
        while (index < position){
            current = current.next;
            index++;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current.data;
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
                sb.append(" <=> ");
            }
            current = current.next;
        }
        sb.append(" <=> Null]");
        return sb.toString();
    }

    public Iterator<E> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E>{
       private Node<E> current;
       private Node<E> lastReturned;

        public ListIterator(){
            current = head;
            lastReturned = null;
        }

        public boolean hasNext(){
            return current != null;
        }

        public E next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            E data = current.data;
            lastReturned = current;
            current = current.next;
            return data;
        }

        public void remove(){
           if(lastReturned == null){
               throw new IllegalStateException("next() not called yet");
           }
           Node<E> toRemove = lastReturned;
           if (toRemove.prev == null){
               head = toRemove.next;
               if (head != null){
                   head.prev = null;
               }else {
                   tail = null;
               }
           }
           else if (toRemove.next == null){
              tail = toRemove.prev;
              tail.next = null;
           }else {
               toRemove.prev.next = toRemove.next;
               toRemove.next.prev = toRemove.prev;
           }
            lastReturned = null;
           size--;
        }
    }
}
