public class StackArrays<E> {

    private E[] elements;
    private int nrOfelements;
    private int maxSize;

    public StackArrays(int maxSize){
        this.maxSize = maxSize;
        elements = (E[]) new Object[maxSize];
        this.nrOfelements = 0;
    }

    public int size(){
        return nrOfelements;
    }

    public boolean isEmpty(){
        return nrOfelements == 0;
    }

    public boolean isFull(){
        return nrOfelements == elements.length;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public void push(E item){
        if (isFull()){
            throw new IllegalStateException("Stack is full");
        }
        elements[nrOfelements++] = item;
    }

    public E peek(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return elements[nrOfelements-1];
    }

    public E pop(){
        if (isEmpty()){
            throw new IllegalStateException("Stack is full");
        }
        if (isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        nrOfelements--;
        E toRemove = elements[nrOfelements];
        elements[nrOfelements] = null;
        return toRemove;
    }


    public String toString(){
        if (isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = nrOfelements-1; i >= 0;i--){
            sb.append(elements[i]);
            if (i > 0){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
