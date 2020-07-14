package test;

import java.util.Arrays;

public class BinarraySearch2 {
    public static void main(String[] args) {
        int arr[] = {7, 9, 12, 13, 14, 15, 16};
        /*int a1[] = Arrays.copyOfRange(arr,3,7);
        int i =0;
        while(i<a1.length) {
            System.out.print(a1[i]);
            i++;
        }*/
        System.out.println(binarraySearch(arr, 5));
        // System.out.println(bsearchWithoutRecursion(arr,9));
    }

    public static int binarraySearch(int arr[], int data) {

        if (arr.length > 0) {

            int len = arr.length;
            int middleIndex = (len - 1) / 2;
            int middleData = arr[middleIndex];
            if (data == middleData) {
                return middleIndex;
            } else if (data > middleData) {
                int arr1[] = Arrays.copyOfRange(arr, middleIndex + 1, len);
                return binarraySearch(arr1, data);
            } else if (data < middleData) {
                int arr1[] = Arrays.copyOfRange(arr, 0, middleIndex);
                return binarraySearch(arr1, data);
            }

        }
        return -1;
    }

    public static int bsearchWithoutRecursion(int a[], int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > key)
                high = mid - 1;
            else if (a[mid] < key)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
