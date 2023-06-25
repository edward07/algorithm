package queue;

import java.util.PriorityQueue;

/**
 * 保存局部有序性
 */
public class KthLargest {

    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            this.add(nums[i]);
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else {
             if (pq.peek() < val) {
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }

    public int peek() {
        return this.pq.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));  // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

}
