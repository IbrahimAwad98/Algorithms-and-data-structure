import java.util.ArrayList;

public class NB5<E> implements StackInt<E> {
    private ArrayList<E> data; //kompisition (stark relation)

    public NB5() {
        data = new ArrayList<>();
    }

    public boolean empty(){
        return data.isEmpty();
    }

    public int size(){
        return data.size();
    }

    public E push(E obj){
        data.add(obj);
        return obj;
    }

    public E peek(){
        if (empty()){
            throw new IllegalStateException("Stack is empty");
        }
        return data.get(data.size() -1);
    }

    public E pop(){
        if (empty()){
            throw new IllegalStateException("Stack is empty");
        }
        return data.remove(data.size() - 1);
    }

    public String toString() {
        if (empty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = data.size() - 1; i >= 0; i--) {
            sb.append(data.get(i));
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
