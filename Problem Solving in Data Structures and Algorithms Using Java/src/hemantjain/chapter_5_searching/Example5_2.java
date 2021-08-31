package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n). As we need to traverse the complete array in worst case. Worst case is
when your desired element is at the last position of the sorted array. However, in the average case
this algorithm is more efficient even though the growth rate is same as unsorted.
Space Complexity: O(1). No extra memory is used to allocate the array.
*/

public class Example5_2 {
    boolean linearSearchSorted(int[] arr, int size, int value) {
        int i = 0;
        for (i = 0; i < size; i++) {
            if (value == arr[i])
                return true;
            else if (value < arr[i])
                return false;

        }
        return false;
    }
}
