package hemantjain.chapter_5_searching;

/*
The Time Complexity of an algorithm is O(n^2) and Space Complexity is O(1)
*/

public class Example5_17 {
    int FindPair(int[] arr, int size, int value) {
        int i, j;
        for (i = 0; i < size; i++)
            for (j = i + 1; j < size; j++)
                if ((arr[i] + arr[j]) == value) {
                    System.out.println("The pair is : " + arr[i] + "," + arr[j]);
                    return 1;
                }
        return 0;
    }
}
