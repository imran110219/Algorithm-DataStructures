package hemantjain.chapter_5_searching;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(1)
*/

import java.util.Arrays;
import java.util.HashSet;

public class Example5_19 {
    int FindPair3(int[] arr, int size, int value) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int i;
        for (i = 0; i < size; i++) {
            if (hs.contains(value - arr[i])) {
                System.out.println("The pair is : " + arr[i] + " , " + (value - arr[i]));

                return 1;
            }
            hs.add(arr[i]);
        }
        return 0;
    }
}
