public class IntList {
    private int[] array;
    private int n;

    public IntList(int initialCapacity){
        if(initialCapacity < 1){
            throw new IllegalArgumentException("Can't be: " + initialCapacity);
        }
        this.array = new int[initialCapacity];
        this.n = 0;
    }

    public int size(){
        return n;
    }

    private void reallocate(){
        int[] copy = new int[array.length * 2];
        for(int i = 0; i < size(); i++){
            copy[i] = array[i];
        }
        array = copy;
    }

    public void add(int element){
        if(n >= array.length){
            reallocate();
        }
        array[n] = element;
        n++;
    }

    public void add(int index, int element){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Wrong index: " + index);
        }

        if(n >= array.length){
            reallocate();
        }
        //måsta flytta åt höger
        for(int i = size(); i > index; i--){
            array[i] = array[i - 1];
        }

        array[index] = element;
        n++;
    }

    public int get(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Wrong index: " + index);
        }
        return array[index];
    }

    public int remove(int index){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Wrong index: " + index);
        }
        int removedElement = array[index];

        //måste flytta element åt vänster
        for(int i = index; i < n - 1; i++){
            array[i] = array[i + 1];
        }
        n--;
        return removedElement;
    }

    public int indexOf(int element){
        for(int i = 0; i < n; i++){
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }

    public int set(int index, int element){
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Wrong index: " + index);
        }
        int oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < n; i++){
            sb.append(array[i]);
            if(i < n - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}