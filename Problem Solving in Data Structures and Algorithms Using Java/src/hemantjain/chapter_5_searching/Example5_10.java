package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n.logn).
Space Complexity: O(1)
*/

import java.util.Arrays;

public class Example5_10 {
    int getMax2(int[] arr, int size) {
        int max = arr[0], maxCount = 1;
        int curr = arr[0], currCount = 1;
        int i;
        Arrays.sort(arr); // Sort(arr,size);
        for (i = 1; i < size; i++) {
            if (arr[i] == arr[i - 1])
                currCount++;
            else {
                currCount = 1;
                curr = arr[i];
            }
            if (currCount > maxCount) {
                maxCount = currCount;
                max = curr;
            }
        }
        return max;
    }
}
