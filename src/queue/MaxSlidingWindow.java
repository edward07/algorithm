package queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

    private PriorityQueue<int[]> pq;

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length  == 0 || nums.length < k) {
            return new int[]{};
        }
        int length = nums.length;
        int[] arr = new int[length - k + 1];

        pq = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return -1;
                } else if (o1[0] < o2[0]) {
                    return 1;
                }
                return 0;
            }
        });

        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            pq.add(new int[]{nums[i], i});
            if (i >= k) {
                start++;
            }
            end++;
            if (i >= k - 1) {
                int[] peek = pq.peek();
                while (peek[1] < start) {
                    pq.poll();
                    peek = pq.peek();
                }
                arr[i-(k-1)] = peek[0];
            }
        }

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
