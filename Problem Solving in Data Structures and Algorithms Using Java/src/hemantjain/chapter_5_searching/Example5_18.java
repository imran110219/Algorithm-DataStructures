package hemantjain.chapter_5_searching;

/*
The Time Complexity of an algorithm is O(n.logn) and Space Complexity is O(1)
*/

import java.util.Arrays;

public class Example5_18 {
    int FindPair2(int[] arr, int size, int value) {
        int first = 0, second = size - 1;
        int curr;
        Arrays.sort(arr);//Sort(arr, size);
        while (first < second) {
            curr = arr[first] + arr[second];
            if (curr == value) {
                System.out.println("The pair is " + arr[first] + "," + arr[second]);
                return 1;
            } else if (curr < value)
                first++;
            else
                second--;

        }
        return 0;
    }
}
