package hemantjain.chapter_5_searching;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(1)
*/

import java.util.Arrays;

public class Example5_14 {
    int getMajority3(int[] arr, int size) {
        int majIndex = 0, count = 1;
        int i;
        int candidate;
        for (i = 1; i < size; i++) {
            if (arr[majIndex] == arr[i])
                count++;
            else
                count--;
            if (count == 0) {
                majIndex = i;
                count = 1;
            }
        }
        candidate = arr[majIndex];
        count = 0;
        for (i = 0; i < size; i++)
            if (arr[i] == candidate)
                count++;
        if (count > size / 2)
            return arr[majIndex];
        else
            return Integer.MIN_VALUE;

    }
}
