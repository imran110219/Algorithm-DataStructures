package hemantjain.chapter_5_searching;

/*
The Time Complexity of an algorithm is O(n) and Space Complexity is O(1)
*/

public class Example5_16 {
    int findMissingNumber(int[] arr, int size, int range) {
        int i;
        int xorSum = 0;
        //get the XOR of all the numbers from 1 to range
        for (i = 1; i <= range; i++)
            xorSum ^= i;
        //loop through the array and get the XOR of elements
        for (i = 0; i < size; i++)
            xorSum ^= arr[i];
        return xorSum;
    }
}
