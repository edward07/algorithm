package queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 239
 */
public class MaxSlidingWindowV3 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] results = new int[len - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                deque.addLast(nums[i]);
            } else {
                while (deque.size() > 0 && nums[i] > deque.getLast()) {
                    deque.removeLast();
                }
                deque.addLast(nums[i]);
            }
        }

        return results;
     }

    public static void main(String[] args) {
        long n = 425439;
        System.out.println(n*(n+1)/2);


        MaxSlidingWindowV3 ms = new MaxSlidingWindowV3();
        int[] inputs = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] results = ms.maxSlidingWindow(inputs, k);
        System.out.println(results);
    }

}
