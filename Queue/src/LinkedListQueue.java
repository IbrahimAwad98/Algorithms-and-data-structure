public class LinkedListQueue<E> {
    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> front, rear;
    private int size;

    public LinkedListQueue(){
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public void enqueue(E item){
       Node<E> newNode = new Node<>(item);
       if (rear == null){
           front = rear = newNode;
       }else {
           rear.next = newNode;
           rear = newNode;
       }
       size++;
    }

    public E dequeue(){
        if (empty()){
            throw new IllegalStateException("Queue is empty");
        }
        E toRemove = front.data;
        front = front.next;
        if (front == null){
            rear = null;
        }
        size--;
        return toRemove;
    }

    public String toString(){
        if (empty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = front;
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
