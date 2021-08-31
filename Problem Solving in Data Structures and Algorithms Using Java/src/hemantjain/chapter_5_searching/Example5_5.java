package hemantjain.chapter_5_searching;

/*
Time Complexity: O(n^2).
Space Complexity: O(1)
*/

public class Example5_5 {
    void printRepeating(int[] arr, int size) {
        int i, j;
        System.out.println(" Repeating elements are ");
        for (i = 0; i < size; i++)
            for (j = i + 1; j < size; j++)
                if (arr[i] == arr[j])
                    System.out.println(" " + arr[i]);
    }
}
