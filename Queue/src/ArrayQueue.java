public class ArrayQueue<E>{
   private E[] queue;
   private int front,rear,size,capacity;

   public ArrayQueue(int capacity){
       this.capacity = capacity;
       queue = (E[]) new Object[capacity];
       this.front = -1;
       this.rear = -1;
       this.size = 0;
   }

   public int size(){
       return size;
   }

   public boolean isEmpty(){
       return size == 0;
   }

   public boolean isFull(){
       return size == capacity;
   }
   public void enqueue(E item){
      if (isFull()){
          throw new IllegalStateException("Queue is full");
      }
      if (isEmpty()){
          front = 0;
      }
      rear = (rear + 1) % capacity;
      queue[rear] = item;
      size++;
   }

   public E peek(){
       if (isEmpty()){
           throw new IllegalStateException("Queue is empty");
       }
       return queue[front];
   }

   public E dequeue(){
       if (isEmpty()){
           throw new IllegalStateException("Queue is empty");
       }
       E toRemove = queue[front];
       queue[front] = null;

       if (front == rear){
           front = -1;
           rear = -1;
       }else {
           front = (front + 1) % capacity;
       }
       size--;
       return toRemove;
   }

   public String toString(){
       if (isEmpty()){
           return "[]";
       }
       StringBuilder sb = new StringBuilder("[");
       int index = front;
       for (int i = 0 ;i < size ;i++){
           sb.append(queue[index]);
           if (i < size -1){
               sb.append(", ");
           }
           index = (index + 1) % capacity;
       }
       sb.append("]");
       return sb.toString();
   }
}
