package hemantjain.chapter_12_hash_table;

import java.util.HashSet;

/**
 * @author Sadman
 */
public class PrintRepeating {
    public static void printRepeating(int[] arr) {
        HashSet<Integer> hs = new HashSet<Integer>();
        System.out.print("Repeating elements are:");
        for (int val : arr) {
            if (hs.contains(val))
                System.out.print(" " + val);
            else
                hs.add(val);
        }
    }
}
