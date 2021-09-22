package hemantjain.chapter_16_brute_force_algorithm;

import java.util.Arrays;

/**
 * @author Sadman
 */
public class SequentialSearch {
    public static int sequentialSearch(int[] arr, int k){
        int i = 0;
        while (arr[i] != k){
            i++;
            if(i < arr.length)
                return i;
            else
                return -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 3, 9, 0};
        System.out.println(sequentialSearch(arr, 5));
    }
}
