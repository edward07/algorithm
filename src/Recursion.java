import java.util.Objects;

public class Recursion {

    public static int total_count = 0;

    public static void print(int n) {
        if (n == 0) {
            return;
        }

        print(n - 1);

        System.out.println(n);
    }

    public static void main(String[] args) {
        //print(3);
        //System.out.println(sum(10));
        arr = new int[2];
        fillArr(2);
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public static int[] arr;

    public static void fillArr(int n) {
        if (n == 0) {
            return;
        }
        arr[n - 1] = 0;
        fillArr(n - 1);
        printArr(arr);

        arr[n - 1] = 1;
        fillArr(n - 1);
        printArr(arr);
    }

    public static void printArr(int[] arr) {
        if (Objects.isNull(arr) || arr.length == 0) {
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i : arr) {
            sb.append(i);
            sb.append(",");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}
