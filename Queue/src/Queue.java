public interface Queue<E>{
    boolean add(E element);
    E element();
    boolean offer(E element);
    E peek();
    E poll();
    E remove();
}
