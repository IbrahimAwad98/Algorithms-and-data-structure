import java.util.Arrays;

public class NArrayList<E> {
    private E[] data;
    private int nrElements;
    private int maxSize;

    public NArrayList(){
        nrElements = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    public boolean add(E element){
        if(nrElements == maxSize)
            reallocate();
        data[nrElements++] = element;
        return true;
    }

    public E get(int index){
        if(0 <= index && index < nrElements)
            return data[index];
        throw new ArrayIndexOutOfBoundsException(index);
    }

    private void reallocate(){
        maxSize *= 2;
        data = Arrays.copyOf(data, maxSize);
    }

    public int getNrElements(){
        return nrElements;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public boolean isEmpty(){
        return nrElements == 0;
    }

    public E remove(int index){
        if(index < 0 || index >= nrElements){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + nrElements);
        }
        E removedElement = data[index];
        // Flytta element åt vänster
        for(int i = index; i < nrElements - 1; i++){
            data[i] = data[i + 1];
        }
        data[nrElements - 1] = null;
        nrElements--;
        return removedElement;
    }

    public E set(int index, E element){
        if(index < 0 || index >= nrElements){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + nrElements);
        }
        E oldElement = data[index];
        data[index] = element;
        return oldElement;
    }

    public int indexOf(E element){
        if(element == null){
            for(int i = 0; i < nrElements; i++){
                if(data[i] == null){
                    return i;
                }
            }
        }
        else{
            for(int i = 0; i < nrElements; i++){
                if(element.equals(data[i])){ //1 operation
                    return i;
                }
            }
        }
        return -1; //om det inte finns då bli -1
    }

    public String toString(){
        if(isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < nrElements; i++){
            sb.append(data[i]);
            if(i < nrElements - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}