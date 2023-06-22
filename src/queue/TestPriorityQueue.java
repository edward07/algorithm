package queue;

import java.util.PriorityQueue;

public class TestPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> pqueue  = new PriorityQueue<>();
        pqueue.add(2);
        pqueue.add(9);
        pqueue.add(5);
        pqueue.add(7);

        System.out.println(pqueue.poll());
        System.out.println(pqueue.poll());
        System.out.println(pqueue.poll());
        System.out.println(pqueue.poll());
    }

}
