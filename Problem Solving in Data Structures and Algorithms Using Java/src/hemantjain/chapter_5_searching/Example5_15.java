package hemantjain.chapter_5_searching;

/*
The Time Complexity of an algorithm is O(n^2) and Space Complexity is O(1)
*/

public class Example5_15 {
    int findMissingNumber(int[] arr, int size) {
        int i, j, found = 0;
        for (i = 1; i <= size; i++) {
            found = 0;
            for (j = 0; j < size; j++) {
                if (arr[j] == i) {
                    found = 1;
                    break;

                }
            }
            if (found == 0)
                return i;

        }
        return Integer.MAX_VALUE;
    }
}
