package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    private PriorityQueue<Integer> pq;

    private Deque<Integer> deque;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length  == 0 || nums.length < k) {
            return new int[]{};
        }
        int length = nums.length;
        int[] arr = new int[length - k + 1];

        pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        });

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int j = k; j < length; j++) {
            int prev = nums[j-k];
            int currMax = pq.peek();
            int next = nums[j];

            if (prev == currMax) {
                arr[j-k] = currMax;
                pq.poll();
                pq.add(next);
            } else {
                if (next >= currMax) {
                    pq.poll();
                    pq.add(next);
                    arr[j-k] = next;
                } else {
                    arr[j-k] = currMax;
                    pq.poll();
                    pq.add(next);
                }
            }
        }

        arr[length - k] = pq.peek();

        return arr;
    }

    public static void main(String[] args) {
        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = msw.maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(ints));

        arr = new int[]{1, 2};
        ints = msw.maxSlidingWindow(arr, 2);
        System.out.println(Arrays.toString(ints));
    }


}
