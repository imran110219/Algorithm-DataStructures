package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n^2).
Space Complexity: O(1)
*/

public class Example5_9 {
    int getMax(int[] arr, int size) {
        int i, j;

        int max = arr[0], count = 1, maxCount = 1;
        for (i = 0; i < size; i++) {
            count = 1;
            for (j = i + 1; j < size; j++)
                if (arr[i] == arr[j])
                    count++;
            if (count > maxCount) {
                max = arr[i];
                maxCount = count;
            }
        }
        return max;
    }
}
