public class Main {
    public static void main(String[] args) {


        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();
        linkedListQueue.enqueue("A");
        linkedListQueue.enqueue("B");
        linkedListQueue.enqueue("C");
        System.out.println(linkedListQueue);
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);



        /*
        //detta liknar stack LIFO
        Dequeue<String> stringDequeue = new Dequeue<>();
        System.out.println("Empty? " + stringDequeue.empty());
        //bygger bakåt (head pekare)
        stringDequeue.offerFirst("C");
        stringDequeue.offerFirst("B");
        stringDequeue.offerLast("A");
        System.out.println(stringDequeue);
        System.out.println("Size= " + stringDequeue.getSize());

        // detta linkar kö FIFO
        Dequeue<String> stringDequeue1 = new Dequeue<>();
        //bygger framåt (tail pekare)
        stringDequeue1.offerLast("A");
        stringDequeue1.offerLast("B");
        stringDequeue1.offerLast("C");
        System.out.println(stringDequeue1);
        System.out.println("Size= " + stringDequeue1.getSize());
        stringDequeue1.pollFirst();
        System.out.println(stringDequeue1);
        System.out.println("Size= " + stringDequeue1.getSize());
         */

    }
}