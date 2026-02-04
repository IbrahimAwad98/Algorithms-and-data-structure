public interface StackInt<E>{
    E push(E element);
    E peek();
    E pop();
    boolean empty();
}
