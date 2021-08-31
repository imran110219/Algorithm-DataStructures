package hemantjain.chapter_5_searching;

/*
Time Complexity: O(logn).
Space Complexity: O(logn) For system stack in recursion
*/

public class Example5_4 {
    boolean BinarySearchRecursive(int[] arr, int low, int high, int value) {
        if (low > high)
            return false;
        int mid = low + (high - low) / 2; // To avoid the overflow
        if (arr[mid] == value)
            return true;
        else if (arr[mid] < value)
            return BinarySearchRecursive(arr, mid + 1, high, value);
        else
            return BinarySearchRecursive(arr, low, mid - 1, value);
    }
}
