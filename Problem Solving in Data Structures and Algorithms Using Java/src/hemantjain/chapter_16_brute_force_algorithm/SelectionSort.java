package hemantjain.chapter_16_brute_force_algorithm;

import java.util.Arrays;

/**
 * @author Sadman
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        int min = 0;
        for (int i = 0; i < arr.length-1; i++) {
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 3, 9, 0};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
