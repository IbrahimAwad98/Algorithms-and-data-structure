import java.util.NoSuchElementException;

public class TestQueue<E> implements Queue<E> {
    private E[] queue;
    private int front;
    private int rear;
    private int maxSize;
    private int size;

    public TestQueue(){
        maxSize = 10;
        front = 0;
        rear = maxSize -1;
        queue = (E[]) new Object[maxSize];
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public boolean offer(E element){
        if(size == maxSize){
            reallocate();
        }
        rear = (rear + 1) % maxSize; //flytta pekare
        queue[rear] = element;
        size++;
        return true;
    }

    private void reallocate(){
        int newMaxSize = 2 * maxSize;
        E[] newQueue = (E[]) new Object[newMaxSize];
        int j = front;
        for (int i = 0; i < size;i++){
            newQueue[i] = queue[j];
            j = (j + 1) % maxSize;
        }
        front = 0;
        rear = size -1;
        maxSize = newMaxSize;
        queue = newQueue;
    }

    public boolean add(E element){
        if(!offer(element)){
            throw new IllegalStateException("Queue full");
        }
        return true;
    }

    public E peek(){
        if (empty()){
            return null;
        }
        return queue[front];
    }

    public E poll(){
        if (empty()){
            return null;
        }
        E toRemove = queue[front];
        front = (front + 1) % maxSize;
        size--;
        return toRemove;
    }

    public E remove(){
        if (empty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return poll();
    }

    public E element(){
        if (empty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return queue[front];
    }

    public String toString(){
        if(empty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int j = front;
        for (int i = 0; i < size;i++){
            sb.append(queue[j]);
            if(i < size -1){
                sb.append(", ");
            }
            j = (j + 1) % maxSize;
        }
        sb.append("]");
        return sb.toString();
    }
}
