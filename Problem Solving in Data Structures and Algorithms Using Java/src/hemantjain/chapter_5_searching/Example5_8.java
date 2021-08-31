package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n).
Space Complexity: O(n)
*/

import java.util.HashSet;

public class Example5_8 {
    void printRepeating4(int[] arr, int size) {
        int[] count = new int[size];
        int i;
        for (i = 0; i < size; i++)
            count[i] = 0;
        System.out.println(" Repeating elements are ");
        for (i = 0; i < size; i++) {
            if (count[arr[i]] == 1)
                System.out.println(" " + arr[i]);
            else
                count[arr[i]]++;
        }
    }
}
