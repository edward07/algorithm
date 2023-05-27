package sort;

/**
 * 归并排序
 * 1.如何拆
 * 2.如何合
 */
public class MergeSort {

    //static int[] arr = {2, 4, 6, 5, 3, 1};

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 5, 3, 1, 9};
        int[] arr = recursion(a);
        printArr(arr);
        //int[] b = {3, 5, 5, 6};
        //mergeArr(a, b);
    }

    public static int[] mergeArr(int[] a, int[] b) {
        //int[] a = {1, 2, 4, 5};
        //int[] b = {3, 5, 5, 6};
        int[] c = new int[a.length + b.length];

        int index = 0;
        int i = 0;
        int j = 0;

        for (; i < a.length; i++) {
            for (; j < b.length; j++) {
                if (a[i] <= b[j]) {
                    c[index] = a[i];
                    index++;
                    break;
                } else {
                    c[index] = b[j];
                    index++;
                    continue;
                }
            }

            if (j == b.length) {
                break;
            }
        }

        while (i < a.length) {
            c[index] = a[i];
            index++;
            i++;
        }

        while (j < b.length) {
            c[index] = b[j];
            index++;
            j++;
        }

        //printArr(c);

        return c;
    }

    public static void printArr(int[] arr) {
        StringBuffer sb  = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static int[] recursion(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int length = arr.length;
        int middle = length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        for (int i = 0; i < middle; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = middle; i < length; i++) {
            rightArr[i - middle] = arr[i];
        }

        int[] leftSortedArr = recursion(leftArr);
        int[] rightSortedArr = recursion(rightArr);

        int[] mergedArr = mergeArr(leftSortedArr, rightSortedArr);
        return mergedArr;

        //System.out.println("leftArr = ");
        //printArr(leftArr);

        //System.out.println("rightArr = ");
        //printArr(rightArr);
    }



}
