public class FullTest {
    public static void main(String[] args) {

        /*
        //testa 1 gränsfall
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);
        System.out.println(arrayQueue); //töm kö
        // front bodde vara null och går ej att poll något
        System.out.println("Front= " + arrayQueue.peek());
        System.out.println("Poll of empty queue: " + arrayQueue.poll()); //antigen null eller exception båda funkar

        //vi skapa kö
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.offer(4);
        arrayQueue.offer(5);
        //om det rätt måste front vara 1
        System.out.println(arrayQueue); // en kö
        System.out.println("Front= " + arrayQueue.peek()); //front i kö

        //test 2 ordning (FIFO)
        arrayQueue.poll();
        arrayQueue.poll();
        System.out.println(arrayQueue);
        // om det är rätt då måste 3 bli först i kö
        System.out.println("Front after poll: " + arrayQueue.peek());

        //testa fylla till kapacitet
        ArrayQueue<String> arrayQueue1 = new ArrayQueue<>(5);
        for (int i = 1; i <= 5;i++){
            arrayQueue1.offer("E" + i);
        }
        System.out.println(arrayQueue1);
        //ordning
        System.out.println("Ordning: ");
        while (arrayQueue1.peek() !=  null){
            System.out.print(arrayQueue1.poll() + " \n");
        }


        //test 3 cirkulär kö
        ArrayQueue<String> stringArrayQueue = new ArrayQueue<>(5);
        System.out.println("New queue: ");
        for (int i = 1; i <= 5; i++){
            stringArrayQueue.offer("A" + i); //fyller den
        }
        System.out.println(stringArrayQueue);
        //vi testar ta bort 3 element
        stringArrayQueue.poll();
        stringArrayQueue.poll();
        stringArrayQueue.poll();
        System.out.println(stringArrayQueue); //A4 och A5 måste vara
        // nu vi lägger till och om det korret ska det wrappa
        stringArrayQueue.offer("F");
        System.out.println(stringArrayQueue); //här är ett fel wrapping
        //första fel var att sätta rear precis som front = 0 och att sätter element innan du räknar rear


        //test 4 reallocate
        ArrayQueue<String> stringArrayQueue1 = new ArrayQueue<>(4);
        stringArrayQueue1.offer("X");
        stringArrayQueue1.offer("Y");
        stringArrayQueue1.offer("Z");
        stringArrayQueue1.offer("W");
        System.out.println("Full queue: " + stringArrayQueue1);
        stringArrayQueue1.poll();
        stringArrayQueue1.poll();
        System.out.println("Efter 2 poll: " + stringArrayQueue1);
        stringArrayQueue1.offer("A");
        stringArrayQueue1.offer("B");
        System.out.println("Efter offer A,B (cirkulär): " + stringArrayQueue1);
        //nu vi testa till 5 element
        stringArrayQueue1.offer("C");
        System.out.println("Efter reallocate: " + stringArrayQueue1); // då ett problem att kopiera array.
         */

    }
}
