package hemantjain.chapter_5_searching;

/*
Sorting algorithms take O(n.logn) time and single scan take O(n) time.
The Time Complexity of an algorithm is O(n.logn) and Space Complexity is O(1)
*/

import java.util.Arrays;

public class Example5_13 {
    int getMajority2(int[] arr, int size)
    {
        int majIndex = size/2, count = 1;
        int i;
        int candidate;
        Arrays.sort(arr); // Sort(arr,size);
        candidate = arr[majIndex];
        count = 0;
        for (i = 0; i < size; i++)
            if(arr[i] == candidate)
                count++;
        if (count > size/2)
            return arr[majIndex];
        else
            return Integer.MIN_VALUE;
    }
}
