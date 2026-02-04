public class Array<E>{
    private E[] array;
    private int n;


    public Array(int capacity){
        array = (E[]) new Object[capacity];
        n = 0;
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void insert(E item){
        if (n == array.length){
            ensure();
        }
        array[n++] = item;
    }

    private void ensure(){
        E[] copy = (E[]) new Object[array.length *2];
        for (int i = 0; i <n; i++){
            copy[i] = array[i];
        }
        array = copy;
    }

    public void delete(int index){
        if (isEmpty()){
            throw new IllegalStateException("Array is empty");
        }
        for (int i = index;i < n - 1;i++){
            array[i] = array[i + 1];
        }
        array[n-1] = null;
        n--;
    }

    public void insert(int index, E item){
        if (index < 0 || index >= n){
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (n == array.length){
            ensure();
        }
        for (int i = n; i > index;i--){
            array[i] = array[i - 1];
        }
        array[index] = item;
        n++;
    }

    public boolean serach(E item){
        if (isEmpty()){
            throw new IllegalStateException("Array is empty");
        }
        for (int i = 0; i< n;i++){
            if (array[i] == item){
                return true;
            }
        }
        return false;
    }

    public E get(int index){
        if (index < 0 || index >= n){
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (isEmpty()){
            throw new IllegalStateException("Array is empty");
        }
       return array[index];
    }

    public String toString(){
        if (isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < n;i++){
            sb.append(array[i]);
            if (i < n -1 ){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
