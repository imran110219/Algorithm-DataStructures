package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n.logn).
Space Complexity: O(1) For system stack in recursion
*/

import java.util.Arrays;

public class Example5_6 {
    void printRepeating2(int[] arr, int size) {
        int i;
        Arrays.sort(arr); // Sort(arr,size);
        System.out.println(" Repeating elements are ");
        for (i = 1; i < size; i++) {
            if (arr[i] == arr[i - 1])
                System.out.println(" " + arr[i]);
        }
    }
}
