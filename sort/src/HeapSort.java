import java.util.Arrays;

/**
 * Created by zhaoziyun on 2019/4/30.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {0, 8, 2, 3, 9, 5, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            swapElement(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    public static void adjustHeap(int[] arr, int start, int length) {
        int temp = arr[start];
        for (int i = 2 * start + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            if (arr[i] > temp) {
                arr[start] = arr[i] ;
                arr[i] = temp;
                start = i;
            } else {
                break;
            }

        }
//        arr[start] = temp;

    }

    public static void swapElement(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
