import java.util.List;

public class MyList<E> {
    private E[] elements;
    private int nrOfElements;

    public MyList(){
        this.elements = (E[]) new Object[10];
        this.nrOfElements = 0;
    }

    public MyList(int capacity){
        if(capacity < 0 ){
            throw new IllegalArgumentException("Not allowed: " + capacity);
        }
        this.elements = (E[]) new Object[capacity];
        this.nrOfElements = 0;
    }

    public int size(){
        return nrOfElements;
    }

    public boolean isEmpty(){
        return nrOfElements == 0;
    }

    public boolean add(E element){
        if(nrOfElements >= elements.length){
            ensure();
        }
        elements[nrOfElements++] = element;
        return true;
    }

    public void add(int index, E element){
        if(index < 0 || index > nrOfElements){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + nrOfElements);
        }
        if(nrOfElements >= elements.length){
            ensure();
        }
        for(int i = nrOfElements; i > index;i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        nrOfElements++;
    }

    private void ensure(){
        int newCapacity = elements.length * 2;
        E[] copy = (E[]) new Object[newCapacity];
        for(int i = 0; i <nrOfElements;i++){
            copy[i] = elements[i];
        }
        elements = copy;
    }

    public E get(int index){
        if(index < 0 || index > nrOfElements){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + nrOfElements);
        }
        return elements[index];
    }

    public E set(int index, E element){
        if(index < 0 || index > nrOfElements){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + nrOfElements);
        }
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public E remove(int index){
        if(index < 0 || index > nrOfElements){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + nrOfElements);
        }
        E removeElement = elements[index];
        for(int i = index; i < nrOfElements - 1; i++){
            elements[i] = elements[i +1];
        }
        elements[nrOfElements-1] = null;
        nrOfElements--;
        return removeElement;
    }

    public int indexOf(Object obj){
        if(obj == null){
            for(int i = 0; i < nrOfElements; i++){
                if(elements[i] == null){
                    return i;
                }
            }
        }
        else {
            for(int i = 0; i < nrOfElements; i++){
                if(obj.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < nrOfElements;i++){
            sb.append(elements[i]);
            if(i < nrOfElements - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static int count(List<String> list, String s){
        int counter = 0;
        for(String element: list){
            if(s == null && element == null){
                counter++;
            }else if(s != null && s.equals(element)){
                counter++;
            }
        }
        return counter;
    }
}
