package sort;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * 快速排序
 * pivot的选择，将数组分为2部分
 * 较小部分的尾，较大部分的头
 * "状态"的思考方式, 既然是分类，那么边界点在哪？
 * 什么是不变的，什么是变化的？
 *
 */
public class QuickSort {

    static int[] arr = {2, 1, 6, 8, 5, 3, 4};
    static int[] arr1 = {5, 7, 6};
    static int[] arr2 = {7, 5, 6};
    static int[] arr3 = {7, 5};
    static int[] arr4 = {5, 6};

    public static void main(String[] args) {
        rearrange(arr);
        System.out.println(Arrays.toString(arr));
        rearrange(arr1);
        System.out.println(Arrays.toString(arr1));
        rearrange(arr2);
        System.out.println(Arrays.toString(arr2));
        rearrange(arr3);
        System.out.println(Arrays.toString(arr3));
        rearrange(arr4);
        System.out.println(Arrays.toString(arr4));
    }

    public static int rearrange(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int length = arr.length;
        int pivot = arr[length - 1];
        int highIdx = -1;

        for (int i = 0; i <= length - 2; i++) {
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
            arr[length - 1] = arr[highIdx];
            arr[highIdx] = pivot;
        }

        return highIdx;
    }

    public static void quickSort(int[] arr) {
        //rearrange(arr);
    }

}
