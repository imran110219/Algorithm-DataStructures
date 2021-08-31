package hemantjain.chapter_5_searching;

/*
Time Complexity: O(logn). We always take half input and throwing out the other half. So the
recurrence relation for binary search is T(n) = T(n/2) + c. Using master theorem (divide and
conquer), we get T(n) = O(logn)
Space Complexity: O(1)
*/

public class Example5_3 {
    boolean Binarysearch(int[] arr, int size, int value) {
        int low = 0;
        int high = size - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2; // To avoid the overflow
            if (arr[mid] == value)
                return true;
            else if (arr[mid] < value)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return false;
    }
}
