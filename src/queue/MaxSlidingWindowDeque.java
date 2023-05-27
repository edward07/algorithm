package queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindowDeque {

    private Deque<Integer> indexDeque = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k) {
            return new int[]{};
        }

        int length = nums.length;
        int[] arr = new int[length - k + 1];
        // 最大值所对应的下标
        int left = 0;
        for (int i = 0; i < length; i++) {
            if (i >= k) {
                left++;
            }
            int val = nums[i];
            Integer minVal = (indexDeque.peekLast() == null) ? null : nums[indexDeque.peekLast()];
            while (minVal != null && val > minVal) {
                indexDeque.removeLast();
                if (indexDeque.peekLast() == null) {
                    break;
                }
                minVal = nums[indexDeque.peekLast()];
            }
            indexDeque.addLast(i);

            int maxIdx = indexDeque.peekFirst();
            if (maxIdx  < left) {
                indexDeque.removeFirst();
            }

            if (i >= k - 1) {
                arr[i - (k -1)] = nums[indexDeque.peekFirst()];
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        MaxSlidingWindowDeque msw = new MaxSlidingWindowDeque();

        int[] arr = new int[]{1};
        int[] ints = msw.maxSlidingWindow(arr, 1);
        System.out.println(Arrays.toString(ints));

        arr = new int[]{1,3,-1,-3,5,3,6,7};
        ints = msw.maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(ints));
    }


}
