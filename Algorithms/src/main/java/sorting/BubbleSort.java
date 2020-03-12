package sorting;

import java.util.Collections;

/**
 * Created by Imran on 1/5/2020.
 */
public class BubbleSort{
    public static void sort(int arr[]){
        int len = arr.length;
        for(int i=0; i<len-1; i++)
            for(int j=0; j<len-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j,j+1);
                }
            }
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int array []= {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort.sort(array);
        bubbleSort.printArray(array);
    }
}
