package sort;

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
    static int[] arr4 = {1, 2, 3, 4, 5};
    static int[] arr5 = {5, 4, 3, 2, 1};

    public static void main(String[] args) {
        quickSort(arr);
        quickSort(arr1);
        quickSort(arr2);
        quickSort(arr3);
        quickSort(arr4);
        quickSort(arr5);
/*
        rearrange(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
        rearrange(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
        rearrange(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
        rearrange(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));
        rearrange(arr4, 0, arr4.length - 1);
        System.out.println(Arrays.toString(arr4));
*/
        //quickSort(arr);
    }

    public static void rearrange(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int length = (end - start) + 1;
        int pivot = arr[length - 1];
        int highIdx = -1;

        for (int i = start; i <= length - 2; i++) {
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
        } else {
            return;
        }

        rearrange(arr, start, highIdx - 1);
        rearrange(arr, highIdx + 1, end);
    }

    public static void quickSort(int[] arr) {
        rearrange(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
