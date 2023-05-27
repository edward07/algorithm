package find;

/**
 * 找到数据中第k个元素
 */
public class FindKthNumber {

    // [1, 2, 3, 4, 5, 6, 8]
    static int[] arr = {2, 1, 6, 8, 5, 3, 4};

    public static void main(String[] args) {
        int idx = findK(arr, 0, arr.length - 1, 6);
        System.out.println(idx);
    }

    public static int findK(int[] arr, int start, int end, int k) {
        if (start >= end) {
            return -1;
        }

        int pivot = arr[end];
        int highIdx = -1;

        for (int i = start; i <= end - 1; i++) {
            if (arr[i] > pivot && highIdx == -1) {
                highIdx = i;
            }
            if (arr[i] < pivot && highIdx != -1) {
                int temp = arr[i];
                arr[i] = arr[highIdx];
                arr[highIdx] = temp;
                highIdx++;
            }
        }

        if (highIdx > -1) {
            arr[end] = arr[highIdx];
            arr[highIdx] = pivot;
        } else {
            highIdx = end;
        }

        if (k == highIdx) {
            return arr[k];
        } else if (k < highIdx) {
            return findK(arr, start, highIdx - 1, k);
        } else {
            return findK(arr, highIdx + 1, end, k);
        }
    }

}
