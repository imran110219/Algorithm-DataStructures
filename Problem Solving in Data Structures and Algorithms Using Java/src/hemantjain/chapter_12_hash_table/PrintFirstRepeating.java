package hemantjain.chapter_12_hash_table;

/**
 * @author Sadman
 */
public class PrintFirstRepeating {
    public static void printFirstRepeating(int[] arr) {
        int i;
        int size = arr.length;
        CountMap<Integer> hs = new CountMap<Integer>();
        for (i = 0; i < size; i++) {
            hs.add(arr[i]);
        }
        for (i = 0; i < size; i++) {
            hs.remove(arr[i]);
            if (hs.containsKey(arr[i])) {
                System.out.println("First Repeating number is : " + arr[i]);
                return;
            }
        }
    }
}
