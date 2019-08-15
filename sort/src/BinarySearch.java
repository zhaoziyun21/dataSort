/**
 * Created by zhaoziyun on 2019/4/30.
 */
public class BinarySearch {
    //二分非递归
    public int search1(int[] arr, int data) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while (max >= min) {
            mid = min + (max - min) / 2;//算出中间值下标
            if (arr[mid] > data) {
                max = mid + 1;
            } else if (arr[mid] < data) {
                min = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    //二分递归
    public int search2(int[] arr, int data,int min,int max) {
        if (max >= min) {
            int  mid = min + (max - min) / 2;//算出中间值下标
            if (arr[mid] > data) {
                max = mid + 1;
                search2(arr,data,min,max);
            } else if (arr[mid] < data) {
                min = mid - 1;
                search2(arr,data,min,max);
            }else{
                return mid;
            }
        }
        return -1;
    }
}
