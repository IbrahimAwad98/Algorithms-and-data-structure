import java.util.EmptyStackException;

public class NB7<E> implements StackInt<E>{

    private static class Node<E>{
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;

    public NB7(){
        head = null;
    }


    public E push(E obj){
        head = new Node<>(obj,head);
        return obj;
    }

    public boolean empty(){
        return head == null;
    }

    public E pop(){
        if(empty()){
            throw new EmptyStackException();
        }
        E result = head.data;
        head = head.next;
        return result;
    }

    public E peek(){
        if(empty()){
            throw new EmptyStackException();
        }else {
            return head.data;
        }
    }

    public int size(){
        int count = 0;
        Node<E> current = head;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }


    public E peek(int n){
        if (n < 0){
            throw new IllegalArgumentException("Cant be negativ");
        }
        Node<E> current = head;
        int index = 0;
        while (current != null){
            if(index == n){
                return current.data;
            }
            current = current.next;
            index++;
        }
        return null;
    }

    public E flush(){
        if(empty()){
            throw new IllegalStateException("Stack is empty");
        }
        Node<E> current = head;
        while (current.next != null){
            current = current.next;
        }
        E value = current.data;
        head = null;
        return value;
    }

    public String toString(){
        if(empty()){
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
