package queue;

import java.util.PriorityQueue;

public class KthLargest {

    private int index;
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        index = k;
        int length = nums.length;
        int initLength = k > length ? length : k;
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < initLength; i++) {
            priorityQueue.add(nums[i]);
        }
        if (k <= length) {
            for (int j = k; j < length; j++) {
                add(nums[j]);
            }
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < index) {
            priorityQueue.add(val);
            return priorityQueue.peek();
        }

        int min = priorityQueue.peek();
        if (val > min) {
            priorityQueue.poll();
            priorityQueue.add(val);
            min = priorityQueue.peek();
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {};
        KthLargest kthLargest = new KthLargest(1, arr);
        System.out.println(kthLargest.add(-3));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(0));
        System.out.println(kthLargest.add(4));
    }

}
