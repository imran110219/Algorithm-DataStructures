package sorting;

import java.util.Arrays;

/**
 * Created by Sadman on 3/9/2020.
 */
public class BucketSort {


    public static void sort(int[] array) {
        int max = getMax(array);
        int[] bucket = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }

        for (int i = 0, j = 0; i <= max; i++) {
            while (bucket[i] > 0) {
                array[j++] = i;
                bucket[i]--;
            }
        }
    }

    private static int getMax(int[] array) {
        int temp = array[0];
        for(int i=1; i<array.length; i++){
            if(array[i] > temp)
                temp = array[i];
        }
        return temp;
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 4, 3, 4, 5, 6, 9, 1, 5 };
        int size = data.length;
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(data);
        bucketSort.printArray(data);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data));
    }
}
