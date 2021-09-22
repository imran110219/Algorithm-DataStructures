package hemantjain.chapter_16_brute_force_algorithm;

import java.util.Arrays;

/**
 * @author Sadman
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 3, 9, 0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
