public class Stack<E> {
    private E[] data;
    private int n;

    public Stack(){
        data = (E[]) new Object[10];
        n = 0;
    }

    public int size(){
        return n;
    }

    public boolean empty(){
        return n == 0;
    }

    public E push(E element){
        if(n == data.length){
            reallocate();
        }
        data[n] = element;
        n++;
        return element;
    }

    private void reallocate(){
        E[] copy = (E[]) new Object[data.length* 2];
        for(int i = 0; i<n;i++){
            copy[i] = data[i];
        }
        data = copy;
    }

    public E peek(){
        if(empty()){
            throw new IllegalStateException("Stack is empty");
        }
        return data[n-1];
    }

    public E pop(){
        if(empty()){
            throw new IllegalStateException("Stack is empty");
        }
        n--;
        E toRemove = data[n];
        data[n] = null;
        return toRemove;
    }

    public String toString(){
        if(empty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for(int i = n- 1; i>= 0;i--){
            sb.append(data[i]);
            if(i > 0){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
