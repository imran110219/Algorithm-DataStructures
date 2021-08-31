package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n^2) + O(1) = O(n^2).
Space Complexity: O(1)
*/

public class Example5_12 {
    int getMajority(int[] arr, int size) {
        int i, j;
        int max = 0, count = 0, maxCount = 0;
        for (i = 0; i < size; i++) {
            for (j = i + 1; j < size; j++)
                if (arr[i] == arr[j])
                    count++;
            if (count > maxCount) {
                max = arr[i];
                maxCount = count;
            }
        }
        if (maxCount > size / 2)

            return max;
        else
            return Integer.MIN_VALUE;

    }
}
