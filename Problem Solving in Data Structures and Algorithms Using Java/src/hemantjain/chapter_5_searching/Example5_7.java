package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n).
Space Complexity: O(n) For system stack in recursion
*/

import java.util.HashSet;

public class Example5_7 {
    void printRepeating3(int[] arr, int size) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int i;

        System.out.println(" Repeating elements are ");
        for (i = 0; i < size; i++) {
            if (hs.contains(arr[i]))
                System.out.println(" " + arr[i]);
            else
                hs.add(arr[i]);

        }
    }
}
