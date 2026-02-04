import java.util.Iterator;

public class SingleLinkedList<E>{

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

    public SingleLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public void addFirst(E element){
        head = new Node<>(element, head);
        size++;
    }

   public void add(int index, E element){
        checkIndex(index);
        if(index == 0){
            addFirst(element);
        }else {
            Node<E> prev = head;
            for(int i =0; i < index -1;i++){
                prev = prev.next;
            }
            prev.next = new Node<>(element,prev.next);
            size++;
        }
   }

   public E set(int index, E element){
        checkIndex(index);
       Node<E> current = head;
       for(int i =0; i <index;i++){
           current = current.next;
       }
       E oldValue = current.data;
       current.data = element;
       return oldValue;
   }

   public E get(int index){
        checkIndex(index);
       Node<E> current = head;
       for(int i = 0; i <index;i++){
           current = current.next;
       }
       return current.data;
   }

   public E remove(int index){
       checkIndex(index);

       E removeData;

       if(index == 0){
           removeData = head.data;
           head = head.next;
           size--;
           return removeData;
       }

       Node<E> prev = head;
       for (int i = 0; i <index-1;i++){
           prev = prev.next;
       }
       removeData = prev.next.data;

       prev.next = prev.next.next;
       size--;
       return removeData;
   }

    public String toString(){
        if(head == null){
            return "[]";
        }
        Node<E> current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null){
            sb.append(current.data);
            if(current.next != null){
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append(" -> null]");
        return sb.toString();
    }

    public Iterator<E> iterator(){
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<E>{
        private Node<E> current;

        public LinkedIterator(){
            current = head;
        }

        public boolean hasNext(){
            return current != null;
        }

        public E next(){
            if(!hasNext()){
                throw new UnsupportedOperationException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    private void checkIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
    }
}
