package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n).
Space Complexity: O(n)
*/

import java.util.Arrays;

public class Example5_11 {
    int getMax3(int[] arr, int size, int range) {
        int max = arr[0], maxCount = 1;
        int[] count = new int[range];
        int i;
        for (i = 0; i < size; i++) {
            count[arr[i]]++;
            if (count[arr[i]] > maxCount) {
                maxCount = count[arr[i]];
                max = arr[i];
            }
        }
        return max;
    }
}
