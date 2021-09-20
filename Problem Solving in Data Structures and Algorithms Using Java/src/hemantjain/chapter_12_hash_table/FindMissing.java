package hemantjain.chapter_12_hash_table;

import java.util.HashSet;

/**
 * @author Sadman
 */
public class FindMissing {
    public static int findMissing(int[] arr, int start, int end) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i : arr) {
            hs.add(i);
        }
        for (int curr = start; curr <= end; curr++) {
            if (!hs.contains(curr))
                return curr;
        }
        return Integer.MAX_VALUE;
    }
}
