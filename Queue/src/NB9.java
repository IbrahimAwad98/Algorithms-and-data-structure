public class NB9<E>{

    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public NB9(){
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size ==0;
    }

    public void enqueue(E element){
      Node<E> newNode = new Node<>(element, null);
      if (empty()){
          front = newNode;
          rear = newNode;
      }else {
          rear.next = newNode;
          rear = newNode;
      }
      size++;
    }

    public E dequeue(){
        if (empty()){
            return null;
        }
        E element = front.data;
        front = front.next;
        size--;
        if (front == null){
            rear = null;
        }
        return element;
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
        sb.append("]");
        return sb.toString();
    }
}
