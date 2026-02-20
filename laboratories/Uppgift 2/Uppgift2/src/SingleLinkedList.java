public class SingleLinkedList<E> {

    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public void addFirst(E element){
        Node<E> newNode = new Node<>(element,head);
        head = newNode;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void addLast(E element){
        Node<E> newNode = new Node<>(element,null);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E element){
        if(index < 0 || index > getSize()){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        //special fall vid insättning av första
        if(index == 0){
            addFirst(element);
            return;
        }
        // O(1) dirket access
        if (index == getSize()){
            addLast(element);
            return;
        }

        Node<E> prev = head;
        for(int i = 0; i <index -1;i++){ //O(n) då sätts i mitten
            prev = prev.next;
        }
        prev.next = new Node<>(element,prev.next);
        size++;
    }

    public E get(int index){
        if(index < 0 || index >= getSize()){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == getSize() - 1){
            return tail.data;
        }
        //Travesera till index som vi vill
        Node<E> current = head;
        for (int i = 0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }

    public E set(int index, E element){
        if(index < 0 || index >= getSize()){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == getSize() -1){
            E oldValue = tail.data;
            tail.data = element;
            return oldValue;
        }
        Node<E> current = head;
        for (int i = 0; i < index;i++){
            current = current.next;
        }
        E oldValue = current.data;
        current.data = element;
        return oldValue;
    }

    public E remove(int index){
        if(index < 0 || index >= getSize()){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removeData;

        //Specialfall vid första element
        if(index == 0){
            removeData = head.data;
            head = head.next;
            if (head == null){
                tail = null;
            }
            size--;
            return removeData;
        }

        Node<E> prev= head;
        for(int i = 0;i<index - 1;i++){
            prev = prev.next;
        }
        removeData = prev.next.data;
        prev.next = prev.next.next;
        if (prev.next == null){
            tail = prev;
        }
        size--;
        return removeData;
    }

    public String toString(){
        if(head == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null){
            sb.append(current.data);
            if(current.next != null){
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}