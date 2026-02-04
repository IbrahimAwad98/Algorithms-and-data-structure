public class StackNode<E>{
    private static class Node<E>{
        private E data;
        private Node<E> next;

        public Node(E data){
            this.data = data;
            next = null;
        }
    }

    private Node<E> top;
    private int size;

    public StackNode(){
        top = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void push(E item){
        Node<E> newNode = new Node<>(item);
        if (top == null){
           top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        size++;
    }

    public E peek(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public E pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        E toRemove = top.data;
        top = top.next;
        return toRemove;
    }

    public String toString(){
        if (isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = top;
        while (current != null){
            sb.append(current.data);
            if (current.next != null){
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append(" -> Null]");
        return sb.toString();
    }
}
